MetaPropertyPath metaPropertyPath = customersDc.getEntityMetaClass().getPropertyPath("hobby");
AggregationInfo info = new AggregationInfo();
info.setPropertyPath(metaPropertyPath);
info.setStrategy(new TableCustomerHobbyAggregation());

Table.Column column = customersTable.getColumn("hobby");
column.setAggregation(info);