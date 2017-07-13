FileDescriptorImageResource resource = image.createResource(Image.FileDescriptorImageResource.class)
        .setFileDescriptor(avatar);
image.setSource(resource);