@Named("clientsTable.edit")
private EditAction clientsTableEdit;

@Override
public void init(Map<String, Object> params) {
    super.init(params);

    clientsTableEdit.getBulkEditorIntegration()
        .setEnabled(true)
        .setOpenType(WindowManager.OpenType.DIALOG);
}