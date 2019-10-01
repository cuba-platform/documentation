@Entity(name = "sales_ExtUser")
@Extends(User.class)
public class ExtUser extends User {

    @Column(name = "ADDRESS", length = 100)
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
