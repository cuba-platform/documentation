@Inject
private Metadata metadata;
@Inject
private LookupField<Color> colorField;
@Inject
private CollectionContainer<Color> colorsDc;

@Subscribe
protected void onInit(InitEvent event) {
    colorField.setNewOptionHandler(caption -> {
        Color color = metadata.create(Color.class);
        color.setName(caption);
        colorsDc.getMutableItems()
                .add(color);
        colorField.setValue(color);
    });
}