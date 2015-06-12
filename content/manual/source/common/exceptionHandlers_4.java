@ManagedBean("cuba_NumericOverflowExceptionHandler")
public class NumericOverflowExceptionHandler extends AbstractGenericExceptionHandler {

    public NumericOverflowExceptionHandler() {
        super(ReportingSQLException.class.getName());
    }

    @Override
    protected boolean canHandle(String className, String message, @Nullable Throwable throwable) {
        return StringUtils.containsIgnoreCase(message, "Numeric field overflow");
    }
...