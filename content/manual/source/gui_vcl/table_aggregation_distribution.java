budgetItemsTable.setAggregationDistributionProvider(context -> {
    Collection<BudgetItem> scope = context.getScope();
    if (scope.isEmpty()) {
        return;
    }

    double value = context.getValue() != null ?
            ((double) context.getValue()) : 0;

    for (BudgetItem budgetItem : scope) {
        budgetItem.setSum(value / 100 * budgetItem.getPercent());
    }
});