@Order(100)
@Component(ColorComponentGenerationStrategy.NAME)
public class ColorComponentGenerationStrategy implements ComponentGenerationStrategy {

    public static final String NAME = "colordatatype_ColorComponentGenerationStrategy";

    @Inject
    private ComponentsFactory componentsFactory;

    @Nullable
    @Override
    public Component createComponent(ComponentGenerationContext context) {
        String property = context.getProperty();
        MetaPropertyPath mpp = resolveMetaPropertyPath(context.getMetaClass(), property);

        if (mpp != null) {
            Range mppRange = mpp.getRange();
            if (mppRange.isDatatype()
                    && ((Datatype) mppRange.asDatatype()) instanceof ColorDatatype) {
                ColorPicker colorPicker = componentsFactory.createComponent(ColorPicker.class);
                colorPicker.setDefaultCaptionEnabled(true);

                Datasource datasource = context.getDatasource();
                if (datasource != null) {
                    colorPicker.setDatasource(datasource, property);
                }

                return colorPicker;
            }
        }

        return null;
    }

    protected MetaPropertyPath resolveMetaPropertyPath(MetaClass metaClass, String property) {
        MetaPropertyPath mpp = metaClass.getPropertyPath(property);

        if (mpp == null && DynamicAttributesUtils.isDynamicAttribute(property)) {
            mpp = DynamicAttributesUtils.getMetaPropertyPath(metaClass, property);
        }

        return mpp;
    }
}