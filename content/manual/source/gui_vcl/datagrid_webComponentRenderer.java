import com.haulmont.cuba.core.global.Configuration;
import com.haulmont.cuba.core.global.GlobalConfig;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.security.entity.User;
import com.haulmont.cuba.web.gui.components.renderers.WebComponentRenderer;

import javax.inject.Inject;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class Users extends AbstractWindow {
    @Inject
    private UiComponents uiComponents;
    @Inject
    private Configuration configuration;
    @Inject
    private DataGrid<User> usersGrid;

    @Override
    public void init(Map<String, Object> params) {

        Map<String, Locale> locales = configuration.getConfig(GlobalConfig.class).getAvailableLocales();
        Map<String, Object> options = new TreeMap<>();
        for (Map.Entry<String, Locale> entry : locales.entrySet()) {
            options.put(entry.getKey(), messages.getTools().localeToString(entry.getValue()));
        }

        DataGrid.Column column = usersGrid.addGeneratedColumn("language",
                new DataGrid.ColumnGenerator<User, Component>() {
                    @Override
                    public Component getValue(DataGrid.ColumnGeneratorEvent<User> event) {
                        LookupField component = uiComponents.create(LookupField.NAME);
                        component.setOptionsMap(options);
                        component.setWidth("100%");

                        User user = event.getItem();
                        component.setValue(user.getLanguage());

                        component.addValueChangeListener(e -> user.setLanguage((String) e.getValue()));

                        return component;
                    }

                    @Override
                    public Class<Component> getType() {
                        return Component.class;
                    }
                });

        column.setRenderer(new WebComponentRenderer());
    }
}