@Inject
private OptionsGroup<Integer, Integer> optionsGroupWithMap;

@Subscribe
protected void onInit(InitEvent event) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("two", 2);
    map.put("four", 4);
    map.put("five", 5);
    map.put("seven", 7);
    optionsGroupWithMap.setOptionsMap(map);
}