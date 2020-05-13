@Property("cuba.test.stringListProp")
@Factory(factory = StringListTypeFactory.class)
@Stringify(stringify = StringListStringify.class)
List<String> getStringListProp();

void setStringListProp(List<String> list);