@Inject
protected Scripting scripting;
...
Integer intResult = scripting.evaluateGroovy("2 + 2", new Binding());

Binding binding = new Binding();
binding.setVariable("instance", new User());
Boolean boolResult = scripting.evaluateGroovy("return PersistenceHelper.isNew(instance)", binding);