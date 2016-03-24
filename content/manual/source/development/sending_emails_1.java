public class NewsItemEdit extends AbstractEditor<NewsItem> {

    // Indicates that a new item was created in this editor
    private boolean justCreated;

    @Inject
    protected EmailService emailService;

    // This method is invoked when a new item is initialized
    @Override
    protected void initNewItem(NewsItem item) {
        justCreated = true;
    }

    // This method is invoked after the screen commit
    @Override
    protected boolean postCommit(boolean committed, boolean close) {
        if (committed && justCreated) {
            // If a new entity was saved to the database, ask a user about sending an email
            showOptionDialog(
                    "Email",
                    "Send the news item by email?",
                    MessageType.CONFIRMATION,
                    new Action[] {
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(Component component) {
                                    sendByEmail();
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    }
            );
        }
        return super.postCommit(committed, close);
    }

    // Queues an email for sending asynchronously
    private void sendByEmail() {
        NewsItem newsItem = getItem();
        EmailInfo emailInfo = new EmailInfo(
                "john.doe@company.com,jane.roe@company.com", // recipients
                newsItem.getCaption(), // subject
                null, // the "from" address will be taken from the "cuba.email.fromAddress" app property
                "com/company/demo/templates/news_item.txt", // body template
                Collections.singletonMap("newsItem", newsItem) // template parameters
        );
        emailService.sendEmailAsync(emailInfo);
    }
}