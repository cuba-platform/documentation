@Inject
protected UserSessionSource userSessionSource;
...
Date date = ...;
String dateStr = Datatypes.getNN(Date.class).format(date, userSessionSource.getLocale());