@Component("sample_ForeignKeyViolationExceptionHandler")
public class ForeignKeyViolationExceptionHandler extends AbstractGenericExceptionHandler {

    public ForeignKeyViolationExceptionHandler() {
        super("java.sql.SQLIntegrityConstraintViolationException");
    }
...