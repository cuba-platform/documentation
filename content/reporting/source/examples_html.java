public class Client extends StandardEntity {

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Column(name = "SUMMARY")
    protected String summary;

    ...
}