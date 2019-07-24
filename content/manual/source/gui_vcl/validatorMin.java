MinValidator minValidator = beanLocator.getPrototype(MinValidator.NAME, 30);
numberField.addValidator(minValidator);