@Inject
private EditorScreens editorScreens;
@Inject
private DataContext dataContext;

private void editFooWithCurrentDataContextAsParent() {
    FooEdit fooEdit = editorScreens.builder(Foo.class, this)
            .withScreen(FooEdit.class)
            .withParentDataContext(dataContext)
            .build();
    fooEdit.show();
}