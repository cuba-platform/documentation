procActionsFrame.initializer()
    //...
    .setStartProcessActionScreenParametersSupplier(() -> {
        Map<String, Object> screenParams = new HashMap<>();
        screenParams.put("contract", getItem());
        return screenParams;
    })
    //...
