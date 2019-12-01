@Install(to = "customersTable.edit", subject = "screenConfigurer")
protected void customersTableEditScreenConfigurer(Screen editorScreen) {
    ((CustomerEdit) editorScreen).setSomeParameter(10);
}
