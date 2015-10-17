@Component("cuba_EntityAccessExceptionHandler")
public class EntityAccessExceptionHandler extends AbstractGenericExceptionHandler {

    public EntityAccessExceptionHandler() {
        super(EntityAccessException.class.getName());
    }
...