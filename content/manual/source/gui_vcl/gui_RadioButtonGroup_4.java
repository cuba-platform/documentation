@Inject
private RadioButtonGroup radioButtonGroup;

@Subscribe
protected void onInit(InitEvent event) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("two", 2);
    map.put("four", 4);
    map.put("five", 5);
    map.put("seven", 7);
    radioButtonGroup.setOptionsMap(map);
}