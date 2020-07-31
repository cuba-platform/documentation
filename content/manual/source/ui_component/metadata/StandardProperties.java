@StudioComponent(caption = "RichTextArea")
@StudioProperties(properties = {
        @StudioProperty(name = "css", type = PropertyType.CSS_BLOCK)
})
interface RichTextArea extends Component {
    @StudioProperty(type = PropertyType.CSS_CLASSNAME_LIST)
    void setStylename(String stylename);

    @StudioProperty(type = PropertyType.SIZE, defaultValue = "auto")
    void setWidth(String width);

    @StudioProperty(type = PropertyType.SIZE, defaultValue = "auto")
    void setHeight(String height);

    @StudioProperty(type = PropertyType.LOCALIZED_STRING)
    void setContextHelpText(String contextHelpText);

    @StudioProperty(type = PropertyType.LOCALIZED_STRING)
    void setDescription(String description);

    @StudioProperty
    @Min(-1)
    void setTabIndex(int tabIndex);
}
