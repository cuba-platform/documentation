@Entity(name = "sample$Terminal")
@Table(name = "SAMPLE_TERMINAL")
public class Terminal extends StandardEntity {
...
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "AIRPORT_ID")
    private Airport airport;

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}