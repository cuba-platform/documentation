CapsLockIndicator indicator = componentsFactory.createComponent(CapsLockIndicator.class);
indicator.setId("indicator");
indicator.setCapsLockOnMessage("Caps Lock is ON");
indicator.setCapsLockOffMessage("Please enter the password");
passwordField.setCapsLockIndicator(indicator);