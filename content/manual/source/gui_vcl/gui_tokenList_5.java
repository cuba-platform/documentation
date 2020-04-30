@Inject
private TokenList<OrderItem> tokenList;
@Inject
private CollectionContainer<OrderItem> allItemsDc;

@Subscribe
public void onAfterShow(AfterShowEvent event) {
    tokenList.setOptions(new ContainerOptions<>(allItemsDc));
}