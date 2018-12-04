lookupField.setOptionStyleProvider(entity -> {
    User user = (User) entity;
    switch (user.getGroup().getName()) {
        case "Company":
            return "company";
        case "Premium":
            return "premium";
        default:
            return "company";
    }
});