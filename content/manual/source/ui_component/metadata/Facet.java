@StudioFacet(
        xmlElement = "clipboardTrigger",
        category = "Facets",
        icon = "icon/clipboardTrigger.svg",
        documentationURL = "https://doc.cuba-platform.com/manual-%VERSION%/gui_ClipboardTrigger.html"
)
public interface ClipboardTrigger extends Facet {

    @StudioProperty(type = PropertyType.COMPONENT_REF, options = "com.haulmont.cuba.gui.components.TextInputField")
    void setInput(TextInputField<?> input);

    @StudioProperty(type = PropertyType.COMPONENT_REF, options = "com.haulmont.cuba.gui.components.Button")
    void setButton(Button button);

    // ...
}