final SecurityContext securityContext = AppContext.getSecurityContext();
executor.submit(new Runnable() {
    public void run() {
        AppContext.setSecurityContext(securityContext);
        // business logic here
    }
});