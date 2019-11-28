import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Foo {
    // create logger
    private static Logger log = LoggerFactory.getLogger(Foo.class);

    private void someMethod() {
        // output message with DEBUG level
        log.debug("invoked someMethod");
    }
}