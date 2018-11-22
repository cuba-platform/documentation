@Inject
private CheckBoxGroup<Integer> checkBoxGroup;

@Subscribe
protected void onInit(InitEvent event) {
    Map<String, Integer> map = new LinkedHashMap<>();
    map.put("two", 2);
    map.put("four", 4);
    map.put("five", 5);
    map.put("seven", 7);
    checkBoxGroup.setOptionsMap(map);
}