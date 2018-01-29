@Component(SalesComponentGenerationStrategy.NAME)
public class SalesComponentGenerationStrategy implements ComponentGenerationStrategy, Ordered {

    public static final String NAME = "sales_SalesComponentGenerationStrategy";

    @Inject
    private ComponentsFactory componentsFactory;
    @Inject
    private Metadata metadata;

    @Nullable
    @Override
    public Component createComponent(ComponentGenerationContext context) {
        String property = context.getProperty();
        MetaClass orderMetaClass = metadata.getClassNN(Order.class);

        // Check the specific field of the Order entity
        // and that the component is created for the FieldGroup component
        if (orderMetaClass.equals(context.getMetaClass())
                && "date".equals(property)
                && context.getComponentClass() != null
                && FieldGroup.class.isAssignableFrom(context.getComponentClass())) {
            DatePicker datePicker = componentsFactory.createComponent(DatePicker.class);

            Datasource datasource = context.getDatasource();
            if (datasource != null) {
                datePicker.setDatasource(datasource, property);
            }

            return datePicker;
        }

        return null;
    }

    @Override
    public int getOrder() {
        return 50;
    }
}