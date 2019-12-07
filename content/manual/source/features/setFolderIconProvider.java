foldersPane.setFolderIconProvider(e -> {
    if (e instanceof AppFolder) {
        return "icons/category.png";
    }
    return "icons/tag.png";
});