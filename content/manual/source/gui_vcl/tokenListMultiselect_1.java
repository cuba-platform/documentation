@Subscribe
protected void onInit(InitEvent event) {
    if (WindowParams.MULTI_SELECT.getBool(getContext())) {
        usersTable.setMultiSelect(true);
    }
}