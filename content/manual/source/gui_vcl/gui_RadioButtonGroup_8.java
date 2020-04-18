@Install(to = "radioButtonGroup", subject = "optionDescriptionProvider")
private String radioButtonGroupOptionDescriptionProvider(Experience experience) {
    switch (experience) {
        case HIGH:
            return "Senior";
        case COMMON:
            return "Middle";
        default:
            return "Junior";
    }
}