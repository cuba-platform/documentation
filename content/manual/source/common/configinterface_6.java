@Property("cuba.email.adminAddress")
@Default("address@company.com")
String getAdminAddress();

@Property("cuba.email.delayCallCount")
@Default("2")
int getDelayCallCount();

@Property("cuba.email.defaultSendingAttemptsCount")
@DefaultInt(10)
int getDefaultSendingAttemptsCount();

@Property("cuba.test.dateProp")
@Default("2013-12-12 00:00:00.000")
@Factory(factory = DateFactory.class)
Date getDateProp();

@Property("cuba.test.integerList")
@Default("1 2 3")
@Factory(factory = IntegerListTypeFactory.class)
List<Integer> getIntegerList();

@Property("cuba.test.stringList")
@Default("aaa|bbb|ccc")
@Factory(factory = StringListTypeFactory.class)
List<String> getStringList();