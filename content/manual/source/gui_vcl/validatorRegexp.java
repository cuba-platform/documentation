RegexpValidator regexpValidator = beanLocator.getPrototype(RegexpValidator.NAME, "[a-z]*");
textField.addValidator(regexpValidator);