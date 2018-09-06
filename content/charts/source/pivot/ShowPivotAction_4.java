ShowPivotAction showPivotAction = new ShowPivotAction(tipsGroupTable)
        .withNativeJson("{" +
                " \"cols\": [\"Time\", \"Day\"]," +
                " \"rows\": [\"Sex\", \"Smoker\"]," +
                " \"editable\": false," +
                " \"renderer\": \"heatmap\"," +
                " \"aggregation\": {" +
                "   \"id\": \"d8fc3fdf-730d-c94f-a0c8-72a9ce3dcb3a\"," +
                "   \"mode\": \"count\"," +
                "   \"properties\": [\"Sex\"]" +
                " }" +
                " }");