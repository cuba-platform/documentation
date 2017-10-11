@Inject
protected UserSessionSource userSessionSource;
@Inject
protected DatatypeRegistry datatypes;

void sample() {
    Date date;
    // ...
    String dateStr = datatypes.getNN(Date.class).format(date, userSessionSource.getLocale());
    // ...
}
