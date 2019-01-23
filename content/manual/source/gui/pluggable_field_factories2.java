import com.company.colordatatype.datatypes.ColorDatatype;
import com.haulmont.chile.core.datatypes.Datatype;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.chile.core.model.MetaPropertyPath;
import com.haulmont.chile.core.model.Range;
import com.haulmont.cuba.core.app.dynamicattributes.DynamicAttributesUtils;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.ColorPicker;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.ComponentGenerationContext;
import com.haulmont.cuba.gui.components.ComponentGenerationStrategy;
import com.haulmont.cuba.gui.components.data.ValueSource;
import org.springframework.core.annotation.Order;

import javax.annotation.Nullable;
import javax.inject.Inject;

@Order(100)
@org.springframework.stereotype.Component(ColorComponentGenerationStrategy.NAME)
public class ColorComponentGenerationStrategy implements ComponentGenerationStrategy {

    public static final String NAME = "colordatatype_ColorComponentGenerationStrategy";

    @Inject
    private UiComponents uiComponents;

    @Nullable
    @Override
    public Component createComponent(ComponentGenerationContext context) {
        String property = context.getProperty();
        MetaPropertyPath mpp = resolveMetaPropertyPath(context.getMetaClass(), property);

        if (mpp != null) {
            Range mppRange = mpp.getRange();
            if (mppRange.isDatatype()
                    && ((Datatype) mppRange.asDatatype()) instanceof ColorDatatype) {
                ColorPicker colorPicker = uiComponents.create(ColorPicker.class);
                colorPicker.setDefaultCaptionEnabled(true);

                ValueSource valueSource = context.getValueSource();
                if (valueSource != null) {
                    //noinspection unchecked
                    colorPicker.setValueSource(valueSource);
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