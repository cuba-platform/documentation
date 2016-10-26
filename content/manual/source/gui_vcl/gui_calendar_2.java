@Inject
private Calendar calendar;

public void addEvent(String caption, String description, Date start, Date end, boolean isAllDay, String stylename) {
    ListCalendarEventProvider listCalendarEventProvider = new ListCalendarEventProvider();
    calendar.setEventProvider(listCalendarEventProvider);
    listCalendarEventProvider.addEvent(generateEvent(caption, description, "2016-10-17 09:00", "2016-10-17 14:00", false, "event-blue"));
}