@UiController("sampler_StackedareaChartSample")
@UiDescriptor("stackedarea-chart-sample.xml")
@LoadDataBeforeShow
public class StackedareaChartSample extends Screen {

    @Inject
    private CollectionContainer<TransportCount> transportCountsDc;

    @Inject
    private SerialChart stackedArea;

    @Subscribe
    private void onInit(InitEvent event) {
        stackedArea.setDataProvider(new ContainerDataProvider(transportCountsDc));
        stackedArea.setCategoryField("year");
    }
}