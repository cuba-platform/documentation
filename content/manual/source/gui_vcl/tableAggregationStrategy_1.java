public class TableCustomerHobbyAggregation implements AggregationStrategy<Hobby, String> {
    @Override
    public String aggregate(Collection<Hobby> propertyValues) {
        Hobby mostFrequent = null;
        long max = 0;
        if (CollectionUtils.isNotEmpty(propertyValues)) {
            for (Hobby hobby : Hobby.values()) {
                long current = propertyValues.stream()
                        .filter(customerHobby -> customerHobby.equals(hobby))
                        .count();
                if (current > max) {
                    mostFrequent = hobby;
                    max = current;
                }
            }
        }
        if (mostFrequent != null) {
            return String.format("%s: %d/%d", mostFrequent.name(), max, propertyValues.size());
        }
        return null;
    }

    @Override
    public Class<String> getResultClass() {
        return String.class;
    }
}