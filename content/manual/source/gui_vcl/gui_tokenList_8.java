@Inject
private CollectionContainer<Tag> tagsDc;
@Inject
private Metadata metadata;
@Inject
private TokenList<Tag> tokenList;

@Subscribe
public void onInit(InitEvent event) {
    tokenList.setNewOptionHandler(string -> {
        Tag newTag = metadata.create(Tag.class);
        newTag.setName(string);
        tagsDc.getMutableItems().add(newTag);
    });
}