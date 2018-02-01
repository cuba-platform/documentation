import java.text.DateFormatSymbols

List result = new ArrayList()
DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(Locale.ENGLISH)
for (i in 0..dateFormatSymbols.months.length - 1) {
    result.add(["header_id" : i + 1, "month_name" : dateFormatSymbols.months[i]])
}
return result