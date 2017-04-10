Map<DayOfWeek, String> days = new HashMap<>(7);
days.put(DayOfWeek.MONDAY,"Heavens and earth");
days.put(DayOfWeek.TUESDAY,"Sky");
days.put(DayOfWeek.WEDNESDAY,"Dry land");
days.put(DayOfWeek.THURSDAY,"Stars");
days.put(DayOfWeek.FRIDAY,"Fish and birds");
days.put(DayOfWeek.SATURDAY,"Animals and man");
days.put(DayOfWeek.SUNDAY,"Rest");
calendar.setDayNames(days);