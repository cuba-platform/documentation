@Inject
private PopupView popupView;

@Override
public void init(Map<String, Object> params) {
    popupView.setMinimizedValue("Hello world!");
}