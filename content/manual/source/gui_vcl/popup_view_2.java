@Inject
private PopupView popupView;

@Subscribe
protected void onInit(InitEvent event) {
    popupView.setMinimizedValue("Hello world!");
}