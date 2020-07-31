@StudioElement(xmlElement = "graph", caption = "Graph")
public interface ChartGraph {

    @StudioProperty(type = PropertyType.PROPERTY_PATH_REF)
    void setValueProperty(String valueProperty);
    String getValueProperty();

    @StudioProperty(type = PropertyType.PROPERTY_PATH_REF)
    void setColorProperty(String colorProperty);
    String getColorProperty();
}
