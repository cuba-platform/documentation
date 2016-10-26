@Inject
private Calendar calendar;

public void addEvents() {
    ListCalendarEventProvider listCalendarEventProvider = new ListCalendarEventProvider();
    calendar.setEventProvider(listCalendarEventProvider);
    listCalendarEventProvider.addEvent(generateEvent("Training", "Student training", "2016-10-17 09:00", "2016-10-17 14:00", false, "event-blue"));
    listCalendarEventProvider.addEvent(generateEvent("Development", "Platform development", "2016-10-17 15:00", "2016-10-17 18:00", false, "event-red"));
    listCalendarEventProvider.addEvent(generateEvent("Party", "Party with friends", "2016-10-22 13:00", "2016-10-22 18:00", false, "event-yellow"));
}

private SimpleCalendarEvent generateEvent(String caption, String description, String start, String end, Boolean allDay, String style) {
    SimpleCalendarEvent calendarEvent = new SimpleCalendarEvent();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    calendarEvent.setCaption(caption);
    calendarEvent.setDescription(description);
    calendarEvent.setStart(df.parse(start, new ParsePosition(0)));
    calendarEvent.setEnd(df.parse(end, new ParsePosition(0)));
    calendarEvent.setAllDay(allDay);
    calendarEvent.setStyleName(style);
    return calendarEvent;
}