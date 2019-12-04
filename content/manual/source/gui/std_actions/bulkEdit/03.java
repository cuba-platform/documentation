@Install(to = "customersTable.bulkEdit", subject = "fieldSorter")
private Map<MetaProperty, Integer> customersTableBulkEditFieldSorter(List<MetaProperty> properties) {
    Map<MetaProperty, Integer> result = new HashMap<>();
    for (MetaProperty property : properties) {
        switch (property.getName()) {
            case "name": result.put(property, 0); break;
            case "email": result.put(property, 1); break;
            default:
        }
    }
    return result;
}
