import com.haulmont.cuba.core.global.FileStorageException;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "Saves DailyReport data")
public interface SaveInputsMBean {
    @ManagedOperation(description = "Creates CSV report with FileLoader")
    String createDailyReport() throws FileStorageException;
}