@Inject
protected Scripting scripting;
...
Binding binding = new Binding();
binding.setVariable("itemId", itemId);
BigDecimal amount = scripting.runGroovyScript("com/abc/sales/CalculatePrice.groovy", binding);