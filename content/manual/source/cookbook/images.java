import com.company.sales.entity.Employee;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("sales_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

    @Inject
    private InstanceContainer<Employee> employeeDc;
    @Inject
    private Image image;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Button clearImageBtn;

    @Subscribe
    protected void onInit(InitEvent event) { <1>
        uploadField.addFileUploadSucceedListener(uploadSucceedEvent -> {
            FileDescriptor fd = uploadField.getFileDescriptor(); <2>
            try {
                fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            getEditedEntity().setImageFile(dataManager.commit(fd)); <3>
            displayImage(); <4>
        });

        uploadField.addFileUploadErrorListener(uploadErrorEvent ->
                notifications.create()
                        .withCaption("File upload error")
                        .show());

        employeeDc.addItemPropertyChangeListener(employeeItemPropertyChangeEvent -> { <5>
            if ("imageFile".equals(employeeItemPropertyChangeEvent.getProperty()))
                updateImageButtons(employeeItemPropertyChangeEvent.getValue() != null);
        });
    }

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) { <6>
        displayImage();
        updateImageButtons(getEditedEntity().getImageFile() != null);
    }

    public void onDownloadImageBtnClick() { <7>
        if (getItem().getImageFile() != null)
            exportDisplay.show(getItem().getImageFile(), ExportFormat.OCTET_STREAM);
    }

    public void onClearImageBtnClick() { <8>
        getEditedEntity().setImageFile(null);
        displayImage();
    }

    private void updateImageButtons(boolean enable) {
        downloadImageBtn.setEnabled(enable);
        clearImageBtn.setEnabled(enable);
    }

    private void displayImage() { <9>
        if (getEditedEntity().getImageFile() != null) {
            image.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getImageFile());
            image.setVisible(true);
        } else {
            image.setVisible(false);
        }
    }
}