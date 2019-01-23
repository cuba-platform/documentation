@Subscribe(target = Target.FRAME)
protected void onBeforeClose(Window.BeforeCloseEvent event) {
    if (event.getCloseOrigin() == CloseOriginType.BREADCRUMBS) {
        event.preventWindowClose();
    }
}