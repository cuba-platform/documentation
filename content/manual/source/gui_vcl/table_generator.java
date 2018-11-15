public Component generateImageFileCell(Employee entity){
    Image image = uiComponents.create(Image.NAME);
    image.setSource(FileDescriptorResource.class).setFileDescriptor(entity.getImageFile());
    return image;
}