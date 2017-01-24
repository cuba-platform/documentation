public class Screen extends AbstractWindow {

    @Inject
    private TextField field1;
    @Inject
    private TextField field2;

    public void init(Map<String, Object> params) {
        // Completely remove bean validation from the UI component
        field1.getValidators().stream()
                .filter(validator -> validator instanceof BeanValidator)
                .forEach(textField::removeValidator);

        // Here validators will check only constraints with explicitly set UiComponentChecks group, because
        // the Default group will not be passed
        field2.getValidators().stream()
                .filter(validator -> validator instanceof BeanValidator)
                .forEach(validator -> {
                    ((BeanValidator) validator).setValidationGroups(new Class[] {UiComponentChecks.class});
                });
    }
}