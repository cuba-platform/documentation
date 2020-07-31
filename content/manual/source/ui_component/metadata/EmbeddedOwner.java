@StudioComponent(category = "Samples",
        unsupportedProperties = {"icon", "responsive"},
        description = "Text field with html support")
public interface RichTextField extends Field<String> {

    @StudioEmbedded
    void setFormattingOptions(FormattingOptions formattingOptions);
    FormattingOptions getFormattingOptions(FormattingOptions formattingOptions);
}
