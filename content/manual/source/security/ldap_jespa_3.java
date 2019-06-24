package com.company.sample.web;

import com.haulmont.cuba.core.sys.AppContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component(DomainAliasesResolver.NAME)
public class DomainAliasesResolver {

    public static final String NAME = "sample_DomainAliasesResolver";

    private static final Logger log = LoggerFactory.getLogger(DomainAliasesResolver.class);

    private Map<String, String> aliases = new HashMap<>();

    public DomainAliasesResolver() {
        String domainAliases = AppContext.getProperty("activeDirectory.aliases");
        if (StringUtils.isEmpty(domainAliases)) {
            return;
        }

        List<String> aliasesPairs = Arrays.stream(StringUtils.split(domainAliases, ';'))
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toList());

        for (String aliasDefinition : aliasesPairs) {
            String[] aliasParts = StringUtils.split(aliasDefinition, '|');
            if (aliasParts == null
                    || aliasParts.length != 2
                    || StringUtils.isBlank(aliasParts[0])
                    || StringUtils.isBlank(aliasParts[1])) {
                log.warn("Incorrect domain alias definition: '{}'", aliasDefinition);
            } else {
                aliases.put(aliasParts[0].toLowerCase(), aliasParts[1]);
            }
        }
    }

    public String getDomainName(String alias) {
        String alias_lc = alias.toLowerCase();

        String domain = aliases.get(alias_lc);
        if (domain == null) {
            return alias;
        }

        log.debug("Resolved domain '{}' from alias '{}'", domain, alias);

        return domain;
    }
}
