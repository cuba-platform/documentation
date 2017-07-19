@Entity(name = "sample$Airport")
@Table(name = "SAMPLE_AIRPORT")
public class Airport extends StandardEntity {
...
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airport")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    protected List<Terminal> terminals;

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public void setTerminals(List<Terminal> terminals) {
        this.terminals = terminals;
    }
}