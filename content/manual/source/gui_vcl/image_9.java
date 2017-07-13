image.setSource(Image.StreamImageResource.class)
        .setStreamSupplier(() -> new FileDataProvider(fileDescriptor).provide());