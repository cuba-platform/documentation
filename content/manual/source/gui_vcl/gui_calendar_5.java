calendar.addEventClickListener(calendarEventClickEvent ->
        notifications.create()
                .withCaption(String.format("Event clicked: %s\n%s",
                        calendarEventClickEvent.getCalendarEvent().getCaption(),
                        calendarEventClickEvent.getCalendarEvent().getDescription()))
                .show());