public class OrderEditorTest {

    OrderEditor editor;

    @Mocked
    Window.Editor frame;

    @Mocked
    AddAction addAction;

    @Before
    public void setUp() throws Exception {
        editor = new OrderEditor();
        editor.setWrappedFrame(frame);
        editor.addAction = addAction;
    }

    @Test
    public void testInit() {
        editor.init(Collections.<String, Object>emptyMap());
        editor.setItem(new Order());

        new Verifications() {
            {
                addAction.setWindowId("sales$Product.browse");
                addAction.setHandler(withInstanceOf(Window.Lookup.Handler.class));
            }
        };
    }
}
