calendar.addEventResizeListener(
        calendarEventResizeEvent ->
                notifications.create()
                        .withCaption(String.format("Event %s is resized",
                                calendarEventResizeEvent.getCalendarEvent().getCaption(),
                                calendarEventResizeEvent.getNewStart().toString(),
                                calendarEventResizeEvent.getNewEnd().toString()))
                        .show());