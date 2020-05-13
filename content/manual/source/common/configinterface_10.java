@Property("cuba.test.integerListProp")
@Factory(factory = IntegerListTypeFactory.class)
@Stringify(stringify = IntegerListStringify.class)
List<Integer> getIntegerListProp();

void setIntegerListProp(List<Integer> list);