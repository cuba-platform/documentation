@Override
public void init(Map<String, Object> params) {
    if (WindowParams.MULTI_SELECT.getBool(getContext())) {
        usersTable.setMultiSelect(true);
    }
}