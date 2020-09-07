@UiController("demo_Dashboard")
@UiDescriptor("dashboard.xml")
public class Dashboard extends Screen {
    @Inject
    private LazyTreeTable<Region> regionTable; // <1>

    @Install(to = "regionTable", subject = "styleProvider")
    private String regionTableStyleProvider(Region region) { // <2>
        return "bold-text";
    }
}
