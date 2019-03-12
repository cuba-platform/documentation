resizableTextArea.addResizeListener(resizeEvent ->
        notifications.create()
                .withCaption("Resized")
                .show());