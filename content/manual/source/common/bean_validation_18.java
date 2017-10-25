public interface MyService {
    String NAME = "sample_MyService";

    @Validated
    void processFoo(@RequiredView("foo-view") Foo foo);

    @Validated
    void processFooList(@RequiredView("foo-view") List<Foo> fooList);

    @Validated
    @RequiredView("bar-view")
    Bar loadBar(@RequiredView("foo-view") Foo foo);
}