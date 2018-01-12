public boolean handleFacebookCallBackRequest(VaadinSession session, VaadinRequest request,
                                            VaadinResponse response) throws IOException {
    if (request.getParameter("code") != null) {
        uiAccessor.accessSynchronously(() -> {
            try {
                String code = request.getParameter("code");

                FacebookUserData userData = facebookService.getUserData(globalConfig.getWebAppUrl(), code);

                User user = socialRegistrationService.findOrRegisterUser(
                        userData.getId(), userData.getEmail(), userData.getName());

                App app = App.getInstance();
                Connection connection = app.getConnection();
                Locale defaultLocale = messages.getTools().getDefaultLocale();

                connection.login(new ExternalUserCredentials(user.getLogin(), defaultLocale));
            } catch (Exception e) {
                log.error("Unable to login using Facebook", e);
            } finally {
                 session.removeRequestHandler(facebookCallBackRequestHandler);
            }
        });

        ((VaadinServletResponse) response).getHttpServletResponse().
            sendRedirect(ControllerUtils.getLocationWithoutParams(redirectUri));

        return true;
    }

    return false;
}