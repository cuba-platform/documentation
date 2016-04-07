CustomerEdit editor = openEditor("sales$Customer.edit", customer, WindowManager.OpenType.THIS_TAB);
editor.addCloseWithCommitListener(() -> {
    // do something
});