calendar.addDateClickListener(
        calendarDateClickEvent ->
                notifications.create()
                        .withCaption(String.format("Date clicked: %s", calendarDateClickEvent.getDate().toString()))
                        .show());