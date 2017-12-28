textArea.addTextChangeListener(event -> {
    byte[] bytes = event.getText().getBytes(StandardCharsets.UTF_8);

    browserFrame.setSource(StreamResource.class)
            .setStreamSupplier(() -> new ByteArrayInputStream(bytes))
            .setMimeType("text/html");
});