public class Client extends StandardEntity {

    @NotNull
    @Column(name = "TITLE", nullable = false)
    protected String title;

    @Lob
    @Column(name = "SUMMARY")
    protected String summary;

    ...
}