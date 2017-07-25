image.setSource(StreamResource.class)
        .setStreamSupplier(() -> new FileDataProvider(fileDescriptor).provide())
        .setBufferSize(1024);