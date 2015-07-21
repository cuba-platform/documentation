@Entity(name = "sales$Customer")
@Table(name = "SALES_CUSTOMER")
public class Customer extends StandardEntity {

    @Column(name = "GRADE")
    protected Integer grade;

    public CustomerGrade getGrade() {
        return grade == null ? null : CustomerGrade.fromId(grade);
    }

    public void setGrade(CustomerGrade grade) {
        this.grade = grade == null ? null : grade.getId();
    }
    ...
}