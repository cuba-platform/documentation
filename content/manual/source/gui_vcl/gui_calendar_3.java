calendar.addDateClickListener(
        calendarDateClickEvent ->
                showNotification(String.format("Date clicked: %s", calendarDateClickEvent.getDate().toString()),
                        NotificationType.HUMANIZED
                )
);