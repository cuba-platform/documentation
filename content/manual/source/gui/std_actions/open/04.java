@Install(to = "customerField.open", subject = "screenConfigurer")
private void customerFieldOpenScreenConfigurer(Screen screen) {
    ((CustomerEdit) screen).setSomeParameter(10);
}
