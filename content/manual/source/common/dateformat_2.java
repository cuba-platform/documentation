@Inject
protected UserSessionSource userSessionSource;
...
Date date = ...;
String dateStr = Datatypes.get(Date.class).format(date, userSessionSource.getLocale());