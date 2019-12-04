@Install(to = "customerField.lookup", subject = "screenConfigurer")
private void customerFieldLookupScreenConfigurer(Screen screen) {
    ((CustomerBrowse) screen).setSomeParameter(10);
}
