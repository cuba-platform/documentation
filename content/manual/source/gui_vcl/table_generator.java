public Component generateImageFileCell(Employee entity) {
    Embedded embedded = componentsFactory.createComponent(Embedded.class);
    embedded.setType(Embedded.Type.IMAGE);
    FileDescriptor userImageFile = entity.getImageFile();
    FileDataProvider dataProvider = new FileDataProvider(userImageFile);
    embedded.setSource(userImageFile.getId() + "." + userImageFile.getExtension(), dataProvider);
    return embedded;
}