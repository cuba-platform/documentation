@Inject
private ScreenBuilders screenBuilders;
@Inject
private DataContext dataContext;

private void editFooWithCurrentDataContextAsParent() {
    FooEdit fooEdit = screenBuilders.editor(Foo.class, this)
            .withScreenClass(FooEdit.class)
            .withParentDataContext(dataContext)
            .build();
    fooEdit.show();
}