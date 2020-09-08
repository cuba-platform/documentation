@StudioAction(category = "List Actions", description = "Sends selected entity by email") // <1>
@ActionType("sendByEmail") // <2>
public class SendByEmailAction<E extends Entity> extends ItemTrackingAction { // <3>

    private final MetadataTools metadataTools;
    private final EmailService emailService;

    private String recipientAddress = "admin@example.com";

    private Function<E, String> bodyGenerator;
    private Function<E, List<EmailAttachment>> attachmentProvider;

    public SendByEmailAction(String id) {
        super(id);
        setCaption("Send by email");
        emailService = AppBeans.get(EmailService.NAME);
        metadataTools = AppBeans.get(MetadataTools.NAME);
    }

    @StudioPropertiesItem(required = true, defaultValue = "admin@example.com") // <4>
    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public Subscription addEmailSentListener(Consumer<EmailSentEvent> listener) { // <5>
        return getEventHub().subscribe(EmailSentEvent.class, listener);
    }

    public void setBodyGenerator(Function<E, String> bodyGenerator) { // <6>
        this.bodyGenerator = bodyGenerator;
    }

    public void setAttachmentProvider(Function<E, List<EmailAttachment>> attachmentProvider) { // <7>
        this.attachmentProvider = attachmentProvider;
    }

    @Override
    public void actionPerform(Component component) {
        if (recipientAddress == null || bodyGenerator == null) {
            throw new IllegalStateException("Required parameters are not set");
        }

        E selected = (E) getTarget().getSingleSelected();
        if (selected == null) {
            return;
        }

        String caption = "Entity " + metadataTools.getInstanceName(selected) + " info";
        String body = bodyGenerator.apply(selected); // <8>
        List<EmailAttachment> attachments = attachmentProvider != null ? attachmentProvider.apply(selected) // <9>
                : new ArrayList<>();

        EmailInfo info = EmailInfoBuilder.create()
                .setAddresses(recipientAddress)
                .setCaption(caption)
                .setBody(body)
                .setBodyContentType(EmailInfo.TEXT_CONTENT_TYPE)
                .setAttachments(attachments.toArray(new EmailAttachment[0]))
                .build();

        emailService.sendEmailAsync(info); // <10>

        EmailSentEvent event = new EmailSentEvent(this, info);
        eventHub.publish(EmailSentEvent.class, event); // <11>
    }

    public static class EmailSentEvent extends EventObject { // <12>
        private final EmailInfo emailInfo;

        public EmailSentEvent(SendByEmailAction origin, EmailInfo emailInfo) {
            super(origin);
            this.emailInfo = emailInfo;
        }

        public EmailInfo getEmailInfo() {
            return emailInfo;
        }
    }
}
