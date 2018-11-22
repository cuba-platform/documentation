@Inject
private RadioButtonGroup<Employee> radioButtonGroup;
@Inject
private CollectionContainer<Employee> employeesCt;

@Subscribe
protected void onInit(InitEvent event) {
    checkBoxGroup.setOptions(new ContainerOptions<>(employeesCt));
}