@Install(to = "userActionsButton", subject = "loginHandler")
private void loginHandler(UserActionsButton.LoginHandlerContext ctx) {
    // do custom logic
}

@Install(to = "userActionsButton", subject = "logoutHandler")
private void logoutHandler(UserActionsButton.LogoutHandlerContext ctx) {
    // do custom logic
}