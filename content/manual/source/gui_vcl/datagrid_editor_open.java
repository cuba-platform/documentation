customersTable.addEditorOpenListener(event -> {
    Map<String, Field> fieldMap = event.getFields();
    Field active = fieldMap.get("active");
    Field grade = fieldMap.get("grade");

    ValueChangeListener listener = e ->
            active.setValue(true);
    grade.addValueChangeListener(listener);
});