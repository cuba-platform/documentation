public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            app = new App();
            app.init(args);
            app.show();
            app.showLoginDialog();
        }
    });
}