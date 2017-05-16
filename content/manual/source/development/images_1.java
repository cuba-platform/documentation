@Table(name = "SAMPLE_EMPLOYEE")
@Entity(name = "sample$Employee")
public class Employee extends StandardEntity {
...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_FILE_ID")
    protected FileDescriptor imageFile;

    public void setImageFile(FileDescriptor imageFile) {
        this.imageFile = imageFile;
    }

    public FileDescriptor getImageFile() {
        return imageFile;
    }
}