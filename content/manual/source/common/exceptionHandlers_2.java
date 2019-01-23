@Component("sample_ForeignKeyViolationExceptionHandler")
public class ForeignKeyViolationExceptionHandler extends AbstractUiExceptionHandler {

    public ForeignKeyViolationExceptionHandler() {
        super("java.sql.SQLIntegrityConstraintViolationException");
    }
...