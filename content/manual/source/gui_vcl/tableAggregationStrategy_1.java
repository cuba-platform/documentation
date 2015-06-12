public class TimeEntryAggregation implements AggregationStrategy<List<TimeEntry>, String> {
    @Override
    public String aggregate(Collection<List<TimeEntry>> propertyValues) {
        HoursAndMinutes total = new HoursAndMinutes();
        for (List<TimeEntry> list : propertyValues) {
            for (TimeEntry timeEntry : list) {
                total.add(HoursAndMinutes.fromTimeEntry(timeEntry));
            }
        }
        return StringFormatHelper.getTotalDayAggregationString(total);
    }
    @Override
    public Class<String> getResultClass() {
        return String.class;
    }
}
