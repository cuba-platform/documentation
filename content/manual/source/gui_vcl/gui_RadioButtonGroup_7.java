@Inject
private RadioButtonGroup<Product> radioButtonGroup;

@Subscribe
public void onInit(InitEvent event) {
    radioButtonGroup.setOptionDescriptionProvider(product -> "Price: " + product.getPrice());
}
