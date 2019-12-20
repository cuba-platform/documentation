public class NewsItemEdit extends StandardEditor<NewsItem> {

    private boolean justCreated; // <1>

    @Inject
    protected EmailService emailService;

    @Inject
    private Dialogs dialogs;

    @Subscribe
    public void onInitEntity(InitEntityEvent<NewsItem> event) { // <2>
        justCreated = true;
    }

    @Subscribe
    public void onAfterCommitChanges(AfterCommitChangesEvent event) { // <3>
        if (justCreated) {
            dialogs.createOptionDialog() // <4>
                    .withCaption("Email")
                    .withMessage("Send the news item by email?")
                    .withActions(
                            new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                                sendByEmail();
                            }),
                            new DialogAction(DialogAction.Type.NO)
                    )
                    .show();
        }
    }

    private void sendByEmail() { // <5>
        NewsItem newsItem = getEditedEntity();

        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses("john.doe@company.com,jane.roe@company.com")
                .setCaption(newsItem.getCaption())
                .setTemplatePath("com/company/prj523/templates/news_item.txt")
                .addTemplateParameter("newsItem", newsItem)
                .build();
        emailService.sendEmailAsync(emailInfo);
    }
}