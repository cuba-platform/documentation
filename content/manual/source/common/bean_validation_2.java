@CheckTaskFeasibility(groups = {Default.class, UiCrossFieldChecks.class}) // custom validation annotation
@Table(name = "DEMO_TASK")
@Entity(name = "demo$Task")
public class Task extends StandardEntity {
    //...
}