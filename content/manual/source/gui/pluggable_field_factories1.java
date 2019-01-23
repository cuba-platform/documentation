import com.company.sales.entity.Order;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.ValueSource;
import org.springframework.core.Ordered;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.sql.Date;

@org.springframework.stereotype.Component(SalesComponentGenerationStrategy.NAME)
public class SalesComponentGenerationStrategy implements ComponentGenerationStrategy, Ordered {

    public static final String NAME = "sales_SalesComponentGenerationStrategy";

    @Inject
    private UiComponents uiComponents;

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
            DatePicker<Date> datePicker = uiComponents.create(DatePicker.TYPE_DATE);

            ValueSource valueSource = context.getValueSource();
            if (valueSource != null) {
                //noinspection unchecked
                datePicker.setValueSource(valueSource);
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