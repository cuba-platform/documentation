@UiController("sales_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private AttributeAccessSupport attributeAccessSupport;

    @Subscribe(id = "orderDc", target = Target.DATA_CONTAINER)
    protected void onOrderDcItemPropertyChange(InstanceContainer.ItemPropertyChangeEvent<Order> event) {
        if ("customer".equals(event.getProperty())) {
            attributeAccessSupport.applyAttributeAccess(this, true, getEditedEntity());
        }
    }

}