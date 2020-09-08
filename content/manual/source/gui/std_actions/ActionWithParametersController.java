@UiController("sales_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {

    @Inject
    private Notifications notifications;

    @Named("customersTable.sendByEmail")
    private SendByEmailAction<Customer> customersTableSendByEmail; // <1>

    @Subscribe("customersTable.sendByEmail")
    public void onCustomersTableSendByEmailEmailSent(SendByEmailAction.EmailSentEvent event) { // <2>
        notifications.create(Notifications.NotificationType.HUMANIZED)
                .withCaption("Email sent")
                .show();
    }

    @Install(to = "customersTable.sendByEmail", subject = "bodyGenerator")
    private String customersTableSendByEmailBodyGenerator(Customer customer) { // <3>
        return "Hello, " + customer.getName();
    }

    @Install(to = "customersTable.sendByEmail", subject = "attachmentProvider")
    private List<EmailAttachment> customersTableSendByEmailAttachmentProvider(Customer customer) { // <4>
        return Collections.emptyList();
    }
}