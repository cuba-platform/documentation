@StudioComponent(xmlElement = "langPicker", category = "Samples")
public interface LanguagePicker extends Field<Locale> {

    @StudioCollection(xmlElement = "options", itemXmlElement = "option",
            itemProperties = {
                    @StudioProperty(name = "caption", type = PropertyType.LOCALIZED_STRING, required = true),
                    @StudioProperty(name = "code", type = PropertyType.STRING),
                    @StudioProperty(name = "flagIcon", type = PropertyType.ICON_ID)
            })
    void setOptions(List<LanguageOption> options);
    List<LanguageOption> getOptions();
}
