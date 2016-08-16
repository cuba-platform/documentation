public class EmployeeBrowse extends AbstractLookup {

    private Logger log = LoggerFactory.getLogger(EmployeeBrowse.class);

    @Inject
    private CollectionDatasource<Employee, UUID> employeesDs;

    @Override
    public void init(Map<String, Object> params) {
        employeesDs.addItemPropertyChangeListener(event -> {
            log.info("Property {} of {} has been changed from {} to {}",
                    event.getProperty(), event.getItem(), event.getPrevValue(), event.getValue());
        });

        employeesDs.addStateChangeListener(event -> {
            log.info("State of {} has been changed from {} to {}",
                    event.getDs(), event.getPrevState(), event.getState());
        });

        employeesDs.addItemChangeListener(event -> {
            log.info("Datasource {} item has been changed from {} to {}",
                    event.getDs(), event.getPrevItem(), event.getItem());
        });

        employeesDs.addCollectionChangeListener(event -> {
            log.info("Datasource {} content has been changed due to {}",
                    event.getDs(), event.getOperation());
        });
    }
}