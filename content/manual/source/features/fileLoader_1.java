import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileLoader;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;
import org.apache.commons.io.IOUtils;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class FileLoaderScreen extends AbstractWindow {

    @Inject
    private Metadata metadata;
    @Inject
    private FileLoader fileLoader;
    @Inject
    private DataManager dataManager;
    @Inject
    private TextArea textAreaIn;
    @Inject
    private TextArea textAreaOut;

    private FileDescriptor fileDescriptor;

    public void onButtonInClick() {
        byte[] bytes = textAreaIn.getRawValue().getBytes();

        fileDescriptor = metadata.create(FileDescriptor.class);
        fileDescriptor.setName("Input.txt");
        fileDescriptor.setExtension("txt");
        fileDescriptor.setSize((long) bytes.length);
        fileDescriptor.setCreateDate(new Date());

        try {
            fileLoader.saveStream(fileDescriptor, () -> new ByteArrayInputStream(bytes));
        } catch (FileStorageException e) {
            throw new RuntimeException(e);
        }

        dataManager.commit(fileDescriptor);
    }

    public void onButtonOutClick() {
        try {
            InputStream inputStream = fileLoader.openStream(fileDescriptor);
            textAreaOut.setValue(IOUtils.toString(inputStream, StandardCharsets.UTF_8));
        } catch (FileStorageException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
