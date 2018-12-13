@UiController("sales_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    private InstanceContainer<Customer> customerDc;
    @Inject
    private InstanceLoader<Customer> customerDl;
    @Inject
    private CollectionLoader<Order> ordersDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        customerDl.load();
        ordersDl.setParameter("customer", customerDc.getItem());
        ordersDl.load();
    }

}