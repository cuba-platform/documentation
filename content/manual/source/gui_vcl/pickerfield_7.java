@Inject
protected PickerField colourField;

@Override
public void init(Map<String, Object> params) {
    colourField.addAction(new AbstractAction("show") {
        @Override
        public void actionPerform(Component component) {
            showColour(colourField.getValue());
        }

        @Override
        public String getCaption() {
            return "";
        }

        @Override
        public String getIcon() {
            return "icons/show.png";
        }
    });
}