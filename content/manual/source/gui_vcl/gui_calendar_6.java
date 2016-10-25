calendar.addEventResizeListener(
        calendarEventResizeEvent ->
                showNotification(String.format("Event %s is resized",
                        calendarEventResizeEvent.getCalendarEvent().getCaption(),
                        calendarEventResizeEvent.getNewStart().toString(),
                        calendarEventResizeEvent.getNewEnd().toString()),
                        NotificationType.HUMANIZED)
);