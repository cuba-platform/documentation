public class ProductEdit extends AbstractEditor<Product> {

    @Named("fieldGroup.customer")
    private PickerField customerField;

    @Override
    protected void postInit() {
        customerField.getLookupAction().setLookupScreenParams(ParamsMap.of("product", getItem()));
    }
}