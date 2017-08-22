showOptionDialog("PLease confirm", "Are you sure?",
        MessageType.CONFIRMATION,
        new Action[] {
            new DialogAction(DialogAction.Type.YES) {
                @Override
                public void actionPerform(Component component) {
                    // do something
                }
            },
            new DialogAction(DialogAction.Type.NO)
        });