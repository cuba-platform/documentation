@Inject
private KeyValueContainer container;
@Inject
private Form form;

@Subscribe
protected void onInit(InitEvent event) {
    Field fooField = (Field) uiComponentsGenerator.generate(
            new ComponentGenerationContext(container.getEntityMetaClass(), "foo"));
    fooField.setCaption("Foo");
    fooField.setValueSource(new ContainerValueSource<>(container, "foo"));
    form.add(fooField);
}