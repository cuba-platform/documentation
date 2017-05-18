Window.Editor window = target.getFrame().openEditor(getWindowId(), newItem, getOpenType(), params, parentDs);
window.addCloseWithCommitListener(() -> {
        //logic code here
});
