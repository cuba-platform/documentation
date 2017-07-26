frameworksTable.addGeneratedColumn("image", entity -> {
    Image image = componentsFactory.createComponent(Image.class);
    image.setDatasource(frameworksTable.getItemDatasource(entity), "image");
    image.setHeight("100px");
    return image;
});