@Component("cuba_OptimisticExceptionHandler")
public class OptimisticExceptionHandler extends AbstractGenericExceptionHandler implements Ordered {

    public OptimisticExceptionHandler() {
        super("javax.persistence.OptimisticLockException");
    }
...