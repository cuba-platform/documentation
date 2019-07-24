DecimalMaxValidator maxValidator = beanLocator.getPrototype(DecimalMaxValidator.NAME, new BigDecimal(100));
numberField.addValidator(maxValidator);