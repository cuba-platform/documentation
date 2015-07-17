AggregationInfo info = new AggregationInfo();
info.setPropertyPath(metaPropertyPath);
info.setStrategy(new TimeEntryAggregation());

Table.Column column = weeklyReportsTable.getColumn(columnId);
column.setAggregation(info);