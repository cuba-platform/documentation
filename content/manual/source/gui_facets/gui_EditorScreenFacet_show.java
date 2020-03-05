@Inject
protected EditorScreenFacet userEditor;

@Subscribe("showDialog")
public void onShowDialogClick(Button.ClickEvent event) {
    userEditor.show();
}