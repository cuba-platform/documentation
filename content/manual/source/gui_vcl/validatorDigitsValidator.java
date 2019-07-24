DigitsValidator digitsValidator = beanLocator.getPrototype(DigitsValidator.NAME, 3, 2);
numberField.addValidator(digitsValidator);