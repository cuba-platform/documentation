@Component("cuba_MyEntityListener")
public class MyEntityListener implements
        BeforeInsertEntityListener<MyEntity>,
        BeforeUpdateEntityListener<MyEntity> {

    @Inject
    protected Metadata metadata;

    @Override
    public void onBeforeInsert(MyEntity entity, EntityManager entityManager) {
        Foo foo = metadata.create(Foo.class);
        ...
        entity.setFoo(foo);
        entityManager.persist(foo);
    }

    @Override
    public void onBeforeUpdate(MyEntity entity, EntityManager entityManager) {
        Foo foo = entityManager.find(Foo.class, entity.getFoo().getId());
        ...
    }
}