grid.addShortcutAction(new ShortcutAction("SHIFT-A", shortcutTriggeredEvent ->
        notifications.create()
                .withCaption("SHIFT-A action")
                .show()
));