@Install(to = "customersTable.view", subject = "screenConfigurer")
protected void customersTableViewScreenConfigurer(Screen editorScreen) {
    ((CustomerEdit) editorScreen).setSomeParameter(10);
}
