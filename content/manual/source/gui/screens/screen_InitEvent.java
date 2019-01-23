@Subscribe
protected void onInit(InitEvent event) {
    Label<String> label = uiComponents.create(Label.TYPE_STRING);
    label.setValue("Hello World");
    getWindow().add(label);
}