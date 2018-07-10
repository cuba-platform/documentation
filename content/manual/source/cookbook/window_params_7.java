@WindowParam
private Product product;

@Override
public void init(Map<String, Object> params) {
    if (product != null && product.getName() != null) {
        getFrame().setCaption("Select a customer for " + product.getName());
    }
}