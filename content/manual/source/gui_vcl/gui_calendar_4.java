calendar.addWeekClickListener(calendarWeekClickEvent ->
        showNotification(String.format("%s week clicked in %s",
                calendarWeekClickEvent.getWeek(),
                calendarWeekClickEvent.getYear()),
                NotificationType.HUMANIZED
        )
);