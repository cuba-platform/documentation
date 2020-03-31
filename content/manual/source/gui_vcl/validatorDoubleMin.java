DoubleMinValidator minValidator = beanLocator.getPrototype(DoubleMinValidator.NAME, new Double(100));
numberField.addValidator(minValidator);