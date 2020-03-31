DecimalMaxValidator maxValidator = beanLocator.getPrototype(DecimalMaxValidator.NAME, new BigDecimal(1000));
numberField.addValidator(maxValidator);