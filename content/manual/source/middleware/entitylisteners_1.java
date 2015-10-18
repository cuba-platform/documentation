@Component("cuba_MyEntityListener")
public class MyEntityListener implements
        BeforeInsertEntityListener<MyEntity>,
        BeforeUpdateEntityListener<MyEntity> {

    @Inject
    protected Persistence persistence;

    @Override
    public void onBeforeInsert(MyEntity entity) {
        EntityManager em = persistence.getEntityManager();
        ...
    }

    @Override
    public void onBeforeUpdate(MyEntity entity) {
        EntityManager em = persistence.getEntityManager();
        ...
    }
}