@Inject
private Calendar<LocalDateTime> calendar;

public void addEvents() {
    ListCalendarEventProvider listCalendarEventProvider = new ListCalendarEventProvider();
    calendar.setEventProvider(listCalendarEventProvider);
    listCalendarEventProvider.addEvent(generateEvent("Training", "Student training", 
            LocalDateTime.of(2016, 10, 17, 9, 0), LocalDateTime.of(2016, 10, 17, 14, 0), false, "event-blue"));
    listCalendarEventProvider.addEvent(generateEvent("Development", "Platform development", 
            LocalDateTime.of(2016, 10, 17, 15, 0), LocalDateTime.of(2016, 10, 17, 18, 0), false, "event-red"));
    listCalendarEventProvider.addEvent(generateEvent("Party", "Party with friends", 
            LocalDateTime.of(2016, 10, 22, 13, 0), LocalDateTime.of(2016, 10, 22, 18, 0), false, "event-yellow"));
}

private SimpleCalendarEvent<LocalDateTime> generateEvent(String caption, String description, LocalDateTime start, LocalDateTime end, Boolean isAllDay, String stylename) {
    SimpleCalendarEvent<LocalDateTime> calendarEvent = new SimpleCalendarEvent<>();
    calendarEvent.setCaption(caption);
    calendarEvent.setDescription(description);
    calendarEvent.setStart(start);
    calendarEvent.setEnd(end);
    calendarEvent.setAllDay(isAllDay);
    calendarEvent.setStyleName(stylename);
    return calendarEvent;
}