DoubleMaxValidator maxValidator = beanLocator.getPrototype(DoubleMaxValidator.NAME, new Double(1000));
numberField.addValidator(maxValidator);