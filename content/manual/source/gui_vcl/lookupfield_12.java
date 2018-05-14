lookupField.setFilterPredicate((itemCaption, searchString) ->
        StringUtils.replaceChars(itemCaption, "ÉÈËÏÎ", "EEEII")
            .toLowerCase()
            .contains(searchString));