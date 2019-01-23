@Route("orders")
public class OrderBrowser extends StandardLookup<Order> {
}

@Route("orders/edit", parentPrefix = "orders")
public class OrderEditor extends StandardEditor<Order> {
}