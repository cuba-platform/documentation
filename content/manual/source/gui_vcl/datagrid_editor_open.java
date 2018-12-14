customersTable.addEditorOpenListener(editorOpenEvent -> {
    Map<String, Field> fieldMap = editorOpenEvent.getFields();
    Field active = fieldMap.get("active");
    Field grade = fieldMap.get("grade");

    ValueChangeListener listener = e ->
            active.setValue(true);
    grade.addValueChangeListener(listener);
});