@ManagedBean("cuba_OptimisticExceptionHandler")
public class OptimisticExceptionHandler extends AbstractGenericExceptionHandler implements Ordered {

    public OptimisticExceptionHandler() {
        super("org.springframework.orm.jpa.JpaOptimisticLockingFailureException");
    }
...