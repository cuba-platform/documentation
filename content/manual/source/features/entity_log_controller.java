@UiController("sample_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
public class CustomerEdit extends StandardEditor<Customer> {
    @Inject
    private InstanceLoader<Customer> customerDl;
    @Inject
    private CollectionLoader<EntityLogItem> entityLogItemsDl;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) { // <1>
        customerDl.load();
    }

    @Subscribe(id = "customerDc", target = Target.DATA_CONTAINER)
    private void onCustomerDcItemChange(InstanceContainer.ItemChangeEvent<Customer> event) { // <2>
        entityLogItemsDl.setParameter("customer", event.getItem().getId());
        entityLogItemsDl.load();
    }
}