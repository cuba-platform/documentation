import com.company.demo.entity.Employee;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("sales_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {

    @Inject
    private UiComponents uiComponents;
    @Inject
    private GroupTable<Employee> employeesTable;

    @Subscribe
    protected void onInit(InitEvent event) { <1>
        employeesTable.addGeneratedColumn("name", entity -> {
            Image image = uiComponents.create(Image.NAME); <2>
            image.setScaleMode(Image.ScaleMode.CONTAIN);
            image.setHeight("40");
            image.setWidth("40");

            FileDescriptor imageFile = entity.getImageFile(); <3>
            image.setSource(FileDescriptorResource.class)
                    .setFileDescriptor(imageFile);

            Label userLogin = uiComponents.create(Label.NAME); <4>
            userLogin.setValue(entity.getName());
            userLogin.setAlignment(Component.Alignment.MIDDLE_LEFT);

            HBoxLayout hBoxLayout = uiComponents.create(HBoxLayout.NAME); <5>
            hBoxLayout.setSpacing(true);
            hBoxLayout.add(image);
            hBoxLayout.add(userLogin);

            return hBoxLayout;
        });
    }
}