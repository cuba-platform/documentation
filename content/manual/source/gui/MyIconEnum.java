public enum MyIcon implements Icons.Icon {

    COOL_ICON("icons/cool-icon.png"), // <1>

    OK("icons/my-ok.png"); // <2>

    protected String source;

    MyIcon(String source) {
        this.source = source;
    }

    @Override
    public String source() {
        return source;
    }
	
    @Override
    public String iconName() {
        return name();
    }
}