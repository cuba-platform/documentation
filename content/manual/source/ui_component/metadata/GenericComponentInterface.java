@StudioComponent(category = "Samples")
public interface LazyTreeTable<E extends Entity> extends Component { // <1>

    @StudioProperty(type = PropertyType.COLLECTION_DATACONTAINER_REF,
            typeParameter = "E") // <2>
    void setContainer(CollectionContainer<E> container);

    void setStyleProvider(@Nullable Function<? super E, String> styleProvider); // <3>
}
