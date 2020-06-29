public class ProductsList extends StandardLookup {
    @Inject
    private GroupTable<Product> productsTable;

    @Override
    public void setLookupComponentMultiSelect(boolean multiSelect) {
        productsTable.setMultiSelect(multiSelect);
    }
}