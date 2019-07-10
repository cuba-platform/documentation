public class FooBrowse extends StandardLookup<Foo> {

    @Inject
    private CollectionContainer<Foo> fooDc;
    @Inject
    private CollectionLoader<Foo> fooDl;

    @Subscribe
    private void onInit(InitEvent event) {
        CustomCollectionContainerSorter sorter = new CustomCollectionContainerSorter(fooDc, fooDl);
        fooDc.setSorter(sorter);
    }
}