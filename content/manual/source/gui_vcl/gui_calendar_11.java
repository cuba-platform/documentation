CalendarEventProvider eventProvider = calendar.getEventProvider();
List<CalendarEvent> events = new ArrayList<>(eventProvider.getEvents());
eventProvider.removeEvent(events.get(events.size()-1));