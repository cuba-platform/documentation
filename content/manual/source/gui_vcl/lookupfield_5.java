@Inject
protected LookupField<Integer> numberOfSeatsField;

@Subscribe
public void onInit(InitEvent event) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("two", 2);
    map.put("four", 4);
    map.put("five", 5);
    map.put("seven", 7);
    numberOfSeatsField.setOptionsMap(map);
}