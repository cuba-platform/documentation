@WindowParam
private Customer customer;

@Override
public void init(Map<String, Object> params) {
    if (customer != null) {
        productsDs.setQuery(
                "select e from sample$Product e left join e.customer c " +
                "where c.id = :param$customer or c is null");
    }
}