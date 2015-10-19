@Component("cuba_NumericOverflowExceptionHandler")
public class NumericOverflowExceptionHandler extends AbstractGenericExceptionHandler {

    public NumericOverflowExceptionHandler() {
        super(EclipseLinkException.class.getName());
    }

    @Override
    protected boolean canHandle(String className, String message, @Nullable Throwable throwable) {
        return StringUtils.containsIgnoreCase(message, "Numeric field overflow");
    }
...