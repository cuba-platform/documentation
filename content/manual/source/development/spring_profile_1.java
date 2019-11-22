public interface SomeService {
    String NAME = "demo_SomeService";

    String hello(String input);
}

@Service(SomeService.NAME)
@Profile("dev")
public class SomeDevServiceBean implements SomeService {
    @Override
    public String hello(String input) {
        return "Service stub: hello " + input;
    }
}

@Service(SomeService.NAME)
@Profile("prod")
public class SomeProdServiceBean implements SomeService {
    @Override
    public String hello(String input) {
        return "Real service: hello " + input;
    }
}