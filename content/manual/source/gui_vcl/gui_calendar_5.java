calendar.addEventClickListener(
        calendarEventClickEvent ->
                showNotification(String.format("Event clicked: %s\n%s",
                        calendarEventClickEvent.getCalendarEvent().getCaption(),
                        calendarEventClickEvent.getCalendarEvent().getDescription()),
                        NotificationType.HUMANIZED
                )
);