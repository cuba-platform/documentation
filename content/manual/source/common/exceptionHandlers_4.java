@Component("sample_ZeroBalanceExceptionHandler")
public class ZeroBalanceExceptionHandler extends AbstractGenericExceptionHandler {

    public ZeroBalanceExceptionHandler() {
        super(ZeroBalanceException.class.getName());
    }

    @Override
    protected boolean canHandle(String className, String message, @Nullable Throwable throwable) {
        return StringUtils.containsIgnoreCase(message, "Insufficient or zero funds in your account");
    }
...