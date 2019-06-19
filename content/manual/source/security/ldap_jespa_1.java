package com.company.sample.web.auth;

import com.company.sample.config.ActiveDirectoryConfig;
import com.company.sample.web.sys.DomainAliasesResolver;
import com.google.common.collect.ImmutableMap;
import com.haulmont.cuba.core.global.ClientType;
import com.haulmont.cuba.core.global.GlobalConfig;
import com.haulmont.cuba.core.sys.AppContext;
import com.haulmont.cuba.core.sys.ConditionalOnAppProperty;
import com.haulmont.cuba.security.auth.*;
import com.haulmont.cuba.security.global.LoginException;
import com.haulmont.cuba.web.auth.WebAuthConfig;
import com.haulmont.cuba.web.security.LoginProvider;
import jespa.http.HttpSecurityService;
import jespa.ntlm.NtlmSecurityProvider;
import jespa.security.PasswordCredential;
import jespa.security.SecurityProviderException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static com.haulmont.cuba.web.security.ExternalUserCredentials.EXTERNAL_AUTH_USER_SESSION_ATTRIBUTE;

@ConditionalOnAppProperty(property = "activeDirectory.integrationEnabled", value = "true")
@Component("sample_JespaAuthProvider")
public class JespaAuthProvider extends HttpSecurityService implements LoginProvider, Ordered {

    private static final Logger log = LoggerFactory.getLogger(JespaAuthProvider.class);

    @Inject
    private GlobalConfig globalConfig;
    @Inject
    private WebAuthConfig webAuthConfig;
    @Inject
    private ActiveDirectoryConfig activeDirectoryConfig;
    @Inject
    private DomainAliasesResolver domainAliasesResolver;
    @Inject
    protected AuthenticationService authenticationService;

    protected static Map<String, DomainInfo> domains = new HashMap<>();
    protected static String defaultDomain;

    @PostConstruct
    public void init() throws ServletException {
        initDomains();

        Map<String, String> properties = new HashMap<>();
        properties.put("jespa.bindstr", getBindStr());
        properties.put("jespa.service.acctname", getAcctName());
        properties.put("jespa.service.password", getAcctPassword());
        properties.put("jespa.account.canonicalForm", "3");
        properties.put("jespa.log.path", globalConfig.getLogDir() + "/jespa.log");
        properties.put("http.parameter.anonymous.name", "anon");
        fillFromSystemProperties(properties);

        try {
            super.init(JespaAuthProvider.class.getName(), null, properties);
        } catch (SecurityProviderException e) {
            throw new ServletException(e);
        }
    }

    @Nullable
    @Override
    public AuthenticationDetails login(Credentials credentials) throws LoginException {
        LoginPasswordCredentials lpCredentials = (LoginPasswordCredentials) credentials;

        String login = lpCredentials.getLogin();
        // parse domain by login
        String domain;
        int atSignPos = login.indexOf("@");
        if (atSignPos >= 0) {
            String domainAlias = login.substring(atSignPos + 1);
            domain = domainAliasesResolver.getDomainName(domainAlias).toUpperCase();
        } else {
            int slashPos = login.indexOf('\\');
            if (slashPos <= 0) {
                throw new LoginException("Invalid name: %s", login);
            }
            String domainAlias = login.substring(0, slashPos);
            domain = domainAliasesResolver.getDomainName(domainAlias).toUpperCase();
        }

        DomainInfo domainInfo = domains.get(domain);
        if (domainInfo == null) {
            throw new LoginException("Unknown domain: %s", domain);
        }

        Map<String, String> securityProviderProps = new HashMap<>();
        securityProviderProps.put("bindstr", domainInfo.getBindStr());
        securityProviderProps.put("service.acctname", domainInfo.getAcctName());
        securityProviderProps.put("service.password", domainInfo.getAcctPassword());
        securityProviderProps.put("account.canonicalForm", "3");
        fillFromSystemProperties(securityProviderProps);

        NtlmSecurityProvider provider = new NtlmSecurityProvider(securityProviderProps);
        try {
            PasswordCredential credential = new PasswordCredential(login, lpCredentials.getPassword().toCharArray());
            provider.authenticate(credential);
        } catch (SecurityProviderException e) {
            throw new LoginException("Authentication error: %s", e.getMessage());
        }

        TrustedClientCredentials trustedCredentials = new TrustedClientCredentials(
                lpCredentials.getLogin(),
                webAuthConfig.getTrustedClientPassword(),
                lpCredentials.getLocale(),
                lpCredentials.getParams());

        trustedCredentials.setClientInfo(lpCredentials.getClientInfo());
        trustedCredentials.setClientType(ClientType.WEB);
        trustedCredentials.setIpAddress(lpCredentials.getIpAddress());
        trustedCredentials.setOverrideLocale(lpCredentials.isOverrideLocale());
        trustedCredentials.setSyncNewUserSessionReplication(lpCredentials.isSyncNewUserSessionReplication());

        Map<String, Serializable> targetSessionAttributes;
        Map<String, Serializable> sessionAttributes = lpCredentials.getSessionAttributes();
        if (sessionAttributes != null
                && !sessionAttributes.isEmpty()) {
            targetSessionAttributes = new HashMap<>(sessionAttributes);
            targetSessionAttributes.put(EXTERNAL_AUTH_USER_SESSION_ATTRIBUTE, true);
        } else {
            targetSessionAttributes = ImmutableMap.of(EXTERNAL_AUTH_USER_SESSION_ATTRIBUTE, true);
        }
        trustedCredentials.setSessionAttributes(targetSessionAttributes);

        return authenticationService.login(credentials);
    }

    @Override
    public boolean supports(Class<?> credentialsClass) {
        return LoginPasswordCredentials.class.isAssignableFrom(credentialsClass);
    }

    @Override
    public int getOrder() {
        return HIGHEST_PLATFORM_PRECEDENCE + 50;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getHeader("User-Agent") != null) {
            String ua = httpServletRequest.getHeader("User-Agent")
                    .toLowerCase();

            boolean windows = ua.contains("windows");
            boolean gecko = ua.contains("gecko") && !ua.contains("webkit");

            if (!windows && gecko) {
                chain.doFilter(request, response);
                return;
            }
        }
        super.doFilter(request, response, chain);
    }

    protected void initDomains() {
        String domainsStr = activeDirectoryConfig.getDomains();
        if (StringUtils.isEmpty(domainsStr)) {
            return;
        }

        String[] strings = domainsStr.split(";");
        for (int i = 0; i < strings.length; i++) {
            String domain = strings[i];
            domain = domain.trim();

            if (StringUtils.isEmpty(domain)) {
                continue;
            }

            String[] parts = domain.split("\\|");
            if (parts.length != 4) {
                log.error("Invalid ActiveDirectory domain definition: " + domain);
                break;
            } else {
                domains.put(parts[0], new DomainInfo(parts[1], parts[2], parts[3]));
                if (i == 0) {
                    defaultDomain = parts[0];
                }
            }
        }
    }

    public String getDefaultDomain() {
        return defaultDomain != null ? defaultDomain : "";
    }

    public String getBindStr() {
        return getBindStr(getDefaultDomain());
    }

    public String getBindStr(String domain) {
        initDomains();
        DomainInfo domainInfo = domains.get(domain);
        return domainInfo != null ? domainInfo.getBindStr() : "";
    }

    public String getAcctName() {
        return getAcctName(getDefaultDomain());
    }

    public String getAcctName(String domain) {
        initDomains();
        DomainInfo domainInfo = domains.get(domain);
        return domainInfo != null ? domainInfo.getAcctName() : "";
    }

    public String getAcctPassword() {
        return getAcctPassword(getDefaultDomain());
    }

    public String getAcctPassword(String domain) {
        initDomains();
        DomainInfo domainInfo = domains.get(domain);
        return domainInfo != null ? domainInfo.getAcctPassword() : "";
    }

    public void fillFromSystemProperties(Map<String, String> params) {
        for (String name : AppContext.getPropertyNames()) {
            if (name.startsWith("jespa.")) {
                params.put(name, AppContext.getProperty(name));
            }
        }
    }
}
