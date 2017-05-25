import com.company.sample.entity.DailyReport;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.security.app.Authenticated;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.util.*;

@Component("sample_SaveInputsMBean")
public class SaveInputs implements SaveInputsMBean {

    @Inject
    private Metadata metadata;

    @Inject
    private FileLoader fileLoader;

    @Inject
    private DataManager dataManager;

    @Authenticated
    @Override
    public String createDailyReport() throws FileStorageException {
        LoadContext<DailyReport> loadContext = LoadContext.create(DailyReport.class)
                .setQuery(LoadContext.createQuery("select r from sample$DailyReport r where r.createTs > CURRENT_DATE"))
                .setView("dailyReport-view");
        List<DailyReport> list = dataManager.loadList(loadContext);
        StringBuilder stringBuilder = new StringBuilder();

        for (DailyReport aList : list) {
            stringBuilder.append(aList.getCreateTs()).append(",").append(aList.getInputValue()).append("\n");
        }
        byte[] bytes = stringBuilder.toString().getBytes();

        FileDescriptor fileDescriptor = metadata.create(FileDescriptor.class);
        fileDescriptor.setName("Report of " + new Date() + ".csv");
        fileDescriptor.setExtension("csv");
        fileDescriptor.setSize((long) bytes.length);
        fileDescriptor.setCreateDate(new java.util.Date());
        fileLoader.saveStream(fileDescriptor, () -> new ByteArrayInputStream(bytes));

        dataManager.commit(fileDescriptor);
        return list.size() + " records saved";
    }
}
