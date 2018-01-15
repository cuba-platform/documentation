suggestionField.setOptionsStyleProvider((field, item) -> {
    User user = (User) item;
    switch (user.getGroup().getName()) {
        case "Company":
            return "company";
        case "Premium":
            return "premium";
        default:
            return "company";
    }
});