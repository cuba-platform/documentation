@Inject
private CollectionContainer<Tag> tagsDc;
@Inject
private Metadata metadata;

@Install(to = "tokenList", subject = "newOptionHandler")
private void tokenListNewOptionHandler(String string) {
    Tag newTag = metadata.create(Tag.class);
    newTag.setName(string);
    tagsDc.getMutableItems().add(newTag);
}