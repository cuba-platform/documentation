@Inject
private RadioButtonGroup<Employee> radioButtonGroup;
@Inject
private CollectionContainer<Employee> employeesCt;

@Subscribe
protected void onInit(InitEvent event) {
    radioButtonGroup.setOptions(new ContainerOptions<>(employeesCt));
}