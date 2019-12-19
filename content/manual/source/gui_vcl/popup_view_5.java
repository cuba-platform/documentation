@Inject
private PopupView popupView;

@Subscribe
public void onInit(InitEvent event) {
	popupView.setPopupPosition(PopupView.PopupPosition.BOTTOM_CENTER);
}