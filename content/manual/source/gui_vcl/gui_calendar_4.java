calendar.addWeekClickListener(calendarWeekClickEvent ->
        notifications.create()
                .withCaption(String.format("%s week clicked in %s",
                        calendarWeekClickEvent.getWeek(),
                        calendarWeekClickEvent.getYear()))
                .show());