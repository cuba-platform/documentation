@Source(type = SourceType.DATABASE)
public interface SalesConfig extends Config {

    @Property("sales.companyName")
    String getCompanyName();
}