@Inject
protected OptionsGroup numberOfSeatsField;

@Override
public void init(Map<String, Object> params) {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("two", 2);
    map.put("four", 4);
    map.put("five", 5);
    map.put("seven", 7);
    numberOfSeatsField.setOptionsMap(map);
}