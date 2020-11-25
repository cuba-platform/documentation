screenValidation.showUnsavedChangesDialog(this, action)
                        .onDiscard(() -> result.resume(closeWithDiscard()))
                        .onCancel(result::fail);