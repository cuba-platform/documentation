@StudioComponent(xmlElement = "serialChart", category = "Samples")
public interface SerialChart extends Component {

    @StudioProperty
    void setCaption(String caption);
    String getCaption();

    @StudioProperty(type = PropertyType.STRING)
    void setBackgroundColor(Color backgroundColor);
    Color getBackgroundColor();

    @StudioElementsGroup(xmlElement = "graphs")
    void setGraphs(List<ChartGraph> graphs);
    List<ChartGraph> getGraphs();
}
