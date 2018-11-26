@UiController("sales_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    private CollectionLoader<Order> ordersDl;

    @Subscribe
    protected void onBeforeLoadData(BeforeLoadDataEvent<Customer> event) {
        ordersDl.setParameter("customer", event.getEntityToEdit());
        ordersDl.load();
    }
}