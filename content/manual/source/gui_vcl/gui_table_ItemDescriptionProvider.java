@Inject
private Table<Department> departmentsTable;

@Subscribe
public void onInit(InitEvent event) {
    departmentsTable.setItemDescriptionProvider(((department, property) -> {
        if (property == null) { // <1>
            if (department.getParentDept() == null) {
                return "Parent Department";
            }
        } else if (property.equals("active")) { // <2>
            return department.getActive()
                    ? "Active department"
                    : "Inactive department";
        }
        return null;
    }));
}