CustomerEdit editor = openEditor("sales$Customer.edit", customer, WindowManager.OpenType.THIS_TAB);
editor.addCloseListener(new CloseListener() {
    @Override
    public void windowClosed(String actionId) {
        // do something
    }
});