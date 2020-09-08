private String contentType = "PLAIN";
private Class<? extends Screen> dialogClass;
private List<Integer> columnNumbers = new ArrayList<>();

@StudioPropertiesItem(name = "ctype", type = PropertyType.ENUMERATION, description = "Email content type", // <1>
        defaultValue = "PLAIN", options = {"PLAIN", "HTML"}
)
public void setContentType(String contentType) {
    this.contentType = contentType;
}

@StudioPropertiesItem(type = PropertyType.SCREEN_CLASS_NAME, required = true) // <2>
public void setDialogClass(Class<? extends Screen> dialogClass) {
    this.dialogClass = dialogClass;
}

@StudioPropertiesItem(type = PropertyType.STRING) // <3>
public void setColumnNumbers(List<Integer> columnNumbers) {
    this.columnNumbers = columnNumbers;
}
