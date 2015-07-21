@Inject
protected Messages messages;
...
String message1 = messages.getMessage(getClass(), "someMessage");
String message2 = messages.getMessage("com.abc.sales.web.customer", "someMessage");
String message3 = messages.getMessage(RoleType.STANDARD);