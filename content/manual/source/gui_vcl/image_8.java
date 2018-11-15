frameworksTable.addGeneratedColumn("image", entity -> {
    Image image = uiComponents.create(Image.NAME);
    image.setDatasource(frameworksTable.getItemDatasource(entity), "image");
    image.setHeight("100px");
    return image;
});