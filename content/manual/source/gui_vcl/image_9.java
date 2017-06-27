image.setSource(StreamImageResource.class).setStreamSupplier(() -> {
    InputStream stream = null;
    try {
        stream = fileLoader.openStream(fileDescriptor);
    } catch (FileStorageException e) {
        throw new RuntimeException(e);
    }
    return stream;
});