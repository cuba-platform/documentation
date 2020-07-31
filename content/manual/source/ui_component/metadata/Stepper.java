import com.haulmont.cuba.gui.meta.*;

@StudioComponent(category = "Samples",
        unsupportedProperties = {"description", "icon", "responsive"},
        xmlns = "http://schemas.company.com/demo/0.1/ui-component.xsd",
        xmlnsAlias = "app",
        icon = "com/company/demo/web/gui/components/icons/stepper.svg",
        canvasBehaviour = CanvasBehaviour.INPUT_FIELD)
@StudioProperties(properties = {
        @StudioProperty(name = "dataContainer", type = PropertyType.DATACONTAINER_REF),
        @StudioProperty(name = "property", type = PropertyType.PROPERTY_PATH_REF, options = "int"),
}, groups = @PropertiesGroup(
        properties = {"dataContainer", "property"}, constraint = PropertiesConstraint.ALL_OR_NOTHING
))
public interface Stepper extends Field<Integer> {

    @StudioProperty(name = "manualInput", type = PropertyType.BOOLEAN, defaultValue = "true")
    void setManualInputAllowed(boolean value);

    boolean isManualInputAllowed();

// ...

}
