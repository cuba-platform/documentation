@Entity(name = "sample$Customer")
@Table(name = "SAMPLE_CUSTOMER")
public class Customer extends StandardEntity {
    //...

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DETAILS_ID")
    protected CustomerDetails details;

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    public CustomerDetails getDetails() {
        return details;
    }
}