openLookup("sample$Product.browse",
        items -> {
            if (!items.isEmpty()) {
                openQuantityDialog((Product) items.iterator().next());
            }
        },
        WindowManager.OpenType.THIS_TAB,
        ParamsMap.of(
                "customer", getItem().getCustomer(),
                "added", orderLinesDs.getItems().stream()
                                        .map(line -> line.getProduct().getId())
                                        .collect(Collectors.toList())
        )
);