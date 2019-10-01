@CheckTaskFeasibility(groups = UiCrossFieldChecks.class)
@Table(name = "DEMO_TASK")
@Entity(name = "demo_Task")
public class Task extends StandardEntity {

    @Future
    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    protected Date dueDate;

    @Min(0)
    @Max(100)
    @Column(name = "PROGRESS", nullable = false)
    protected Integer progress;

    //...
}