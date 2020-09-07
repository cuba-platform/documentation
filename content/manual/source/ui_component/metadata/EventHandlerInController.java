@UiController("demo_Dashboard")
@UiDescriptor("dashboard.xml")
public class Dashboard extends Screen {
    // ...

    @Subscribe("regionTable")
    public void onRegionTableNodeExpand(LazyTreeTable.NodeExpandEvent event) {

    }
}
