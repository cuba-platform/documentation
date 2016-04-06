public class MyDatasource extends CustomCollectionDatasource<SomeEntity, UUID> {

    private SomeService someService = AppBeans.get(SomeService.NAME);

    @Override
    protected Collection<SomeEntity> getEntities(Map<String, Object> params) {
        return someService.getEntities();
    }
}