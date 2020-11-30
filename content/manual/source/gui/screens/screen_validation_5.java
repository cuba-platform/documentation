@Table(name = "DEMO_EVENT")
@Entity(name = "demo_Event")
@NamePattern("%s|name")
@EventDate(groups = {Default.class, UiCrossFieldChecks.class})
public class Event extends StandardEntity {
    private static final long serialVersionUID = 1477125422077150455L;

    @Column(name = "NAME")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE")
    private Date endDate;

    ...
}