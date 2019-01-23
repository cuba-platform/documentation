calendar.addEventMoveListener(calendarEventMoveEvent ->
        notifications.create()
                .withCaption(String.format("Event %s moved to %s",
                        calendarEventMoveEvent.getCalendarEvent().getCaption(),
                        calendarEventMoveEvent.getNewStart().toString()))
                .show());