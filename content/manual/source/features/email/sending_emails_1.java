@UiController("sample_NewsItem.edit")
@UiDescriptor("news-item-edit.xml")
@EditedEntityContainer("newsItemDc")
@LoadDataBeforeShow
public class NewsItemEdit extends StandardEditor<NewsItem> {

    private boolean justCreated; // <1>

    @Inject
    protected EmailService emailService;
	
    @Inject
    protected Dialogs dialogs;

    @Subscribe
    public void onInitEntity(InitEntityEvent<NewsItem> event) { // <2>
        justCreated = true;
    }

    @Subscribe(target = Target.DATA_CONTEXT)
    public void onPostCommit(DataContext.PostCommitEvent event) { // <3>
        if (justCreated) {
            dialogs.createOptionDialog() // <4>
                    .withCaption("Email")
                    .withMessage("Send the news item by email?")
                    .withType(Dialogs.MessageType.CONFIRMATION)
                    .withActions(
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(Component component) {
                                    sendByEmail();
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    )
                    .show();
        }
    }

    private void sendByEmail() { // <5>
        NewsItem newsItem = getEditedEntity();
        EmailInfo emailInfo = new EmailInfo(
                "john.doe@company.com,jane.roe@company.com", // <6>
                newsItem.getCaption(), // <7>
                null, // <8>
                "com/company/demo/templates/news_item.txt", // <9>
                Collections.singletonMap("newsItem", newsItem) // <10>
        );
        emailService.sendEmailAsync(emailInfo);
    }
}