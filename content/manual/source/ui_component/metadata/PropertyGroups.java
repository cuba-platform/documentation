@StudioComponent(
        caption = "RichTextField",
        category = "Fields",
        canvasBehaviour = CanvasBehaviour.INPUT_FIELD)
@StudioProperties(properties = {
        @StudioProperty(name = "dataContainer", type = PropertyType.DATACONTAINER_REF),
        @StudioProperty(name = "property", type = PropertyType.PROPERTY_PATH_REF, options = "string")
}, groups = @PropertiesGroup(
        properties = {"dataContainer", "property"}, constraint = PropertiesConstraint.ALL_OR_NOTHING
))
interface RichTextField extends Component {
    // ...
}
