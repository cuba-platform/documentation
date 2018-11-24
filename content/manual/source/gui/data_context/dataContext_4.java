@Inject
private Screens screens;
@Inject
private DataContext dataContext;

private void openFooScreenWithCurrentDataContextAsParent() {
    FooScreen fooScreen = screens.create(FooScreen.class);
    fooScreen.setParentDataContext(dataContext);
    fooScreen.show();
}