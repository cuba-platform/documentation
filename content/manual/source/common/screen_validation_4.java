screenValidation.showSaveConfirmationDialog(this, action)
                    .onCommit(() -> result.resume(closeWithCommit()))
                    .onDiscard(() -> result.resume(closeWithDiscard()))
                    .onCancel(result::fail);