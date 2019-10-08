@Inject
private LookupField<Customer> lookupField;
@Inject
private Image imageResource;

@Subscribe
private void onInit(InitEvent event) {
   lookupField.setOptionImageProvider(e -> 
      imageResource.createResource(ThemeResource.class).setPath("icons/radio.svg"));
}