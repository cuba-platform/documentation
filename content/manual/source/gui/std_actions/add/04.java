@Install(to = "customersTable.add", subject = "screenConfigurer")
private void customersTableAddScreenConfigurer(Screen screen) {
    ((CustomerBrowse) screen).setSomeParameter(10);
}
