@Property("cuba.test.dateProp")
@Factory(factory = DateFactory.class)
@Stringify(stringify = DateStringify.class)
Date getDateProp();

void setDateProp(Date date);