@Inject
private UiComponents uiComponents;
@Inject
private InstanceContainer<Customer> customerDc;
@Inject
private Form form;

@Subscribe
private void onInit(InitEvent event) {
    TextField<String> emailField = uiComponents.create(TextField.TYPE_STRING);
    emailField.setCaption("Email");
    emailField.setWidthFull();
    emailField.setValueSource(new ContainerValueSource<>(customerDc, "email"));
    form.add(emailField);
}