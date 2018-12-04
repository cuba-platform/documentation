lookupField.setOptionIconProvider(entity -> {
    if (entity.getType() == LegalStatus.LEGAL)
        return "icons/icon-office.png";
    return "icons/icon-user.png";
});