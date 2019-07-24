MaxValidator maxValidator = beanLocator.getPrototype(MaxValidator.NAME, 20500);
numberField.addValidator(maxValidator);