@UiController("sample_NewScreen")
@UiDescriptor("new-screen.xml")
public class NewScreen extends Screen {

    @Inject
    private TextField<String> field1;
    @Inject
    private TextField<String> field2;

    @Subscribe
    protected void onInit(InitEvent event) {
        field1.getValidators().stream()
                .filter(BeanPropertyValidator.class::isInstance)
                .forEach(field1::removeValidator); <1>

        field2.getValidators().stream()
                .filter(BeanPropertyValidator.class::isInstance)
                .forEach(validator -> {
                    ((BeanPropertyValidator) validator).setValidationGroups(new Class[] {UiComponentChecks.class}); <2>
                });
    }
}