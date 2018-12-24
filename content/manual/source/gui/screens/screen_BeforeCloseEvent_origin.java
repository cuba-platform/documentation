@Subscribe(target = Target.FRAME)
protected void onBeforeClose1(Window.BeforeCloseEvent event) {
    if(event.getCloseOrigin() == CloseOriginType.BREADCRUMBS)
        event.preventWindowClose();
}