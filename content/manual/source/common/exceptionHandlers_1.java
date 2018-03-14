@Component("sample_ZeroBalanceExceptionHandler")
public class ZeroBalanceExceptionHandler extends AbstractGenericExceptionHandler {

    public ZeroBalanceExceptionHandler() {
        super(ZeroBalanceException.class.getName());
    }
...