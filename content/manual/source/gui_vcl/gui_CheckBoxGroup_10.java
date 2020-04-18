@Install(to = "checkBoxGroup", subject = "optionDescriptionProvider")
private String checkBoxGroupOptionDescriptionProvider(Experience experience) {
    switch (experience) {
        case HIGH:
            return "Senior";
        case COMMON:
            return "Middle";
        default:
            return "Junior";
    }
}