@Inject
private CheckBoxGroup<RoleType> checkBoxGroup;

@Subscribe
protected void onInit(InitEvent event) {
    checkBoxGroup.setOptionsEnum(RoleType.class);
}