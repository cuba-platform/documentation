@Install(to = "devicesTable.iconOS", subject = "columnGenerator")
private Icons.Icon devicesTableIconOSColumnGenerator(DataGrid.ColumnGeneratorEvent<Device> event) {
    return CubaIcon.valueOf(event.getItem().getIconOS());
}