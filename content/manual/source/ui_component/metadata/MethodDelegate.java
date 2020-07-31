@StudioFacet
public interface LookupScreenFacet<E extends Entity> extends Facet {

    // ...

    void setSelectHandler(Consumer<Collection<E>> selectHandler);

    void setOptionsProvider(Supplier<ScreenOptions> optionsProvider);

    void setTransformation(Function<Collection<E>, Collection<E>> transformation);
    
    @StudioProperty(type = PropertyType.COMPONENT_REF, typeParameter = "E",
            options = "com.haulmont.cuba.gui.components.ListComponent")
    void setListComponent(ListComponent<E> listComponent);
}