@StudioComponent(xmlElement = "myChart", category = "Samples")
public interface MyChart extends Component {

    @StudioProperty(name = "position", caption = "scrollbar position",
            xmlElement = "scrollBar", xmlAttribute = "position",
            type = PropertyType.ENUMERATION, options = {"TOP", "BOTTOM"})
    void setScrollBarPosition(String scrollBarPosition);
    String getScrollBarPosition();

    @StudioProperty(name = "color", caption = "scrollbar color",
            xmlElement = "scrollBar", xmlAttribute = "color")
    void setScrollBarColor(String scrollBarColor);
    String getScrollBarColor();
}
