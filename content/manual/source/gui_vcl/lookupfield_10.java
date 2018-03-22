lookupField.setOptionIconProvider(item -> {
    RoleType roleType = (RoleType) item;

    if (roleType.ordinal() % 2 == 0) {
        return "icons/alarm.svg";
    }

    return "icons/cloud.svg";
});