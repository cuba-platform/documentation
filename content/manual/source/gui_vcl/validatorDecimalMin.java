DecimalMinValidator minValidator = beanLocator.getPrototype(DecimalMinValidator.NAME, new BigDecimal(100));
numberField.addValidator(minValidator);