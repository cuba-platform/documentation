@Inject
private Metadata metadata;

@Inject
protected LookupField colourField;

@Inject
protected CollectionDatasource<Colour, UUID> coloursDs;

@Override
public void init(Map<String, Object> params) {
    colourField.setNewOptionAllowed(true);
    colourField.setNewOptionHandler(new LookupField.NewOptionHandler() {
        @Override
        public void addNewOption(String caption) {
            Colour colour = metadata.create(Colour.class);
            colour.setName(caption);
            coloursDs.addItem(colour);
            colourField.setValue(colour);
        }
    });
}