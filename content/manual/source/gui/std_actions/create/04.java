@Install(to = "customersTable.create", subject = "screenConfigurer")
protected void customersTableCreateScreenConfigurer(Screen editorScreen) {
    ((CustomerEdit) editorScreen).setSomeParameter(10);
}
