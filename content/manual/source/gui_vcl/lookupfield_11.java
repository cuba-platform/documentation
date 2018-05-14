BiFunction<String, String, Boolean> predicate = String::contains;
lookupField.setFilterPredicate((itemCaption, searchString) ->
        predicate.apply(itemCaption.toLowerCase(), searchString));