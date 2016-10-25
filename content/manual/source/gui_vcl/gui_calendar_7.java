calendar.addEventMoveListener(
        calendarEventMoveEvent ->
                showNotification(String.format("Event %s moved to %s",
                calendarEventMoveEvent.getCalendarEvent().getCaption(),
                calendarEventMoveEvent.getNewStart().toString()),
                NotificationType.HUMANIZED
        )
);