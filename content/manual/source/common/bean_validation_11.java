public class Cart {

    @Size(min = 1)
    @Valid
    private List<Product> products;

    // ...
}