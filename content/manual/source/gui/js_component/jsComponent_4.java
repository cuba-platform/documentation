jsComponent.addFunction("valueChanged", callbackEvent -> {
    JsonArray arguments = callbackEvent.getArguments();

    notifications.create()
            .withCaption(StringUtils.join(arguments, ", "))
            .show();
});