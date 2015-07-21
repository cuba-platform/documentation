public class AppComponentPalette implements ComponentPalette {
    ...

    @Override
    public Map<String, Class<? extends ComponentLoader>> getLoaders() {
        Map<String, Class<? extends ComponentLoader>> loaders = new HashMap<>();
        loaders.put(MyComponent.NAME, MyComponentLoader.class);
        return loaders;
    }
}