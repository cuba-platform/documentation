@Inject
protected OptionsGroup numberOfSeatsField;

@Override
public void init(Map<String, Object> params) {
    List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(4);
    list.add(5);
    list.add(7);
    numberOfSeatsField.setOptionsList(list);
}