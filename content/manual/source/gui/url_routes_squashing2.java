@Route("orders")
public class OrderBrowser extends StandardLookup<Order> {
}

@Route(value = "orders/edit", parentPrefix = "orders")
public class OrderEditor extends StandardEditor<Order> {
}
