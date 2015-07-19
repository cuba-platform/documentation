public class MyDatasource extends CollectionDatasourceImpl<SomeEntity, UUID> {

    private SomeService someService = AppBeans.get(SomeService.NAME);

    @Override
    protected void loadData(Map<String, Object> params) {
        detachListener(data.values());
        data.clear();

        for (SomeEntity entity : someService.getEntities()) {
            data.put(entity.getId(), entity);
            attachListener(entity);
        }
    }
}