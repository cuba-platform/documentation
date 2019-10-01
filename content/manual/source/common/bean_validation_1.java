@Table(name = "DEMO_CUSTOMER")
@Entity(name = "demo_Customer")
public class Customer extends StandardEntity {

    @Size(min = 3) // length of value must be longer then 3 characters
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Min(1) // minimum value
    @Max(5) // maximum value
    @Column(name = "GRADE", nullable = false)
    protected Integer grade;

    @Pattern(regexp = "\\S+@\\S+") // value must conform to the pattern
    @Column(name = "EMAIL")
    protected String email;

    //...
}