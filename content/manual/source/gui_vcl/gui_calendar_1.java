@Inject
private Calendar<Date> calendar;

public void generateEvent(String caption, String description, Date start, Date end, boolean isAllDay, String stylename) {
    SimpleCalendarEvent<Date> calendarEvent = new SimpleCalendarEvent<>();
    calendarEvent.setCaption(caption);
    calendarEvent.setDescription(description);
    calendarEvent.setStart(start);
    calendarEvent.setEnd(end);
    calendarEvent.setAllDay(isAllDay);
    calendarEvent.setStyleName(stylename);
    calendar.getEventProvider().addEvent(calendarEvent);
}