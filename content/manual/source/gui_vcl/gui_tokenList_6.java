@Inject
private TokenList<OrderItem> tokenList;
@Inject
private CollectionContainer<OrderItem> allItemsDc;

@Subscribe
public void onAfterShow(AfterShowEvent event) {
    Map<String, OrderItem> options = new TreeMap<>();
        for (OrderItem item : allItemsDc.getItems()) {
            options.put("Brand new ".concat(item.getProduct().getName()), item);
        }
    tokenList.setOptionsMap(options);
}