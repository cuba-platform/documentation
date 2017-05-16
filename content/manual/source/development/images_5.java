import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.components.*;
import com.company.employeeimages.entity.Employee;
import com.haulmont.cuba.gui.export.FileDataProvider;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.util.Map;

public class EmployeeBrowse extends AbstractLookup {

    @Inject
    private ComponentsFactory componentsFactory;

    @Inject
    private GroupTable<Employee> employeesTable;

    @Override
    public void init(Map<String, Object> params) {

        employeesTable.addGeneratedColumn("name", entity -> {
            Embedded embedded = componentsFactory.createComponent(Embedded.class);

            embedded.setType(Embedded.Type.IMAGE);
            embedded.setWidth("40px");
            embedded.setHeight("40px");

            FileDescriptor userImageFile = entity.getImageFile();
            FileDataProvider dataProvider = new FileDataProvider(userImageFile);
            embedded.setSource(userImageFile.getId() + "." + userImageFile.getExtension(), dataProvider);

            Label userLogin = componentsFactory.createComponent(Label.class);
            userLogin.setValue(entity.getName());
            userLogin.setAlignment(Alignment.MIDDLE_LEFT);

            HBoxLayout hBox = componentsFactory.createComponent(HBoxLayout.class);
            hBox.setSpacing(true);
            hBox.add(embedded);
            hBox.add(userLogin);

            return hBox;
        });
    }
}