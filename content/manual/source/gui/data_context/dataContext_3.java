public class FooScreen extends Screen {

    @Inject
    private DataContext dataContext;

    public void setParentDataContext(DataContext parentDataContext) {
        dataContext.setParent(parentDataContext);
    }
}