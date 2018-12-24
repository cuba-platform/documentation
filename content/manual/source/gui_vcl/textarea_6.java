textArea.addResizeListener(resizeEvent ->
        notifications.create()
                .withCaption("Resized")
                .show());