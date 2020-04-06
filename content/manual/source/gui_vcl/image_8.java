frameworksTable.addGeneratedColumn("image", entity -> {
    Image image = uiComponents.create(Image.NAME);
    image.setValueSource(new ContainerValueSource<>(frameworksTable.getInstanceContainer(entity), "image"));
    image.setHeight("100px");
    return image;
});