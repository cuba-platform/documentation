@Inject
private CheckBoxGroup<RoleType> checkBoxGroup;

@Subscribe
protected void onInit(InitEvent event) {
    checkBoxGroup.setOptions(new EnumOptions<>(RoleType.class));
}