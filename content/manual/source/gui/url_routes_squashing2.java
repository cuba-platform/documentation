@Route("orders")
public class OrderBrowser extends Screen {
}

@Route(path = "orders/edit", parentPrefix = "orders")
public class OrderEditor extends Screen implements EditorScreen {
}