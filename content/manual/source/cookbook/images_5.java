import com.company.employeeimages.entity.Employee;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;

import javax.inject.Inject;
import java.util.Map;

import static com.haulmont.cuba.gui.components.Image.*;

public class EmployeeBrowse extends AbstractLookup {

    @Inject
    private UiComponents uiComponents;

    @Inject
    private GroupTable<Employee> employeesTable;

    @Override
    public void init(Map<String, Object> params) {

        employeesTable.addGeneratedColumn("name", entity -> {
            Image image = uiComponents.create(Image.NAME);
            image.setScaleMode(ScaleMode.CONTAIN);
            image.setHeight("40");
            image.setWidth("40");

            FileDescriptor userImageFile = entity.getImageFile();
            image.setSource(FileDescriptorResource.class).setFileDescriptor(userImageFile);

            Label userLogin = uiComponents.create(Label.NAME);
            userLogin.setValue(entity.getName());
            userLogin.setAlignment(Alignment.MIDDLE_LEFT);

            HBoxLayout hBox = uiComponents.create(HBoxLayout.NAME);
            hBox.setSpacing(true);
            hBox.add(image);
            hBox.add(userLogin);

            return hBox;
        });
    }
}