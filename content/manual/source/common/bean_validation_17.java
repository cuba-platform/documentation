@Inject
private BeanValidation beanValidation;

public void save(Foo foo) {
    Validator validator = beanValidation.getValidator();
    Set<ConstraintViolation<Foo>> violations = validator.validate(foo);
    // ...
}