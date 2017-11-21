Hello <% print (user.active ? user.login : 'user') %>

<% if (user.email.endsWith('@company.com')) { %>

The password for your account has been reset.

Please login with the following temporary password:
${password}
and immediately create a new one for the further work.

Thank you

<% } else {%>

Please contact your system administrator for a new password.

<%}%>
