@Inject
private CheckBoxGroup<Product> checkBoxGroup;

@Subscribe
public void onInit(InitEvent event) {
    checkBoxGroup.setOptionDescriptionProvider(product -> "Price: " + product.getPrice());
}