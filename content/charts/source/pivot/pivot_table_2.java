public class PivotSampleScreen extends Screen {

    @Inject
    private PivotTable tipsCustomAggregatorPivotTable;

    @Subscribe
    protected void onInit(InitEvent event) {
        tipsCustomAggregatorPivotTable.setSortersFunction(
                new JsFunction("function(attr){if(attr == \"Day\"){return $.pivotUtilities.sortAs([\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\",\"Sun\"]);}}"));

        tipsCustomAggregatorPivotTable.getAggregation().setFunction(
                new JsFunction("$.pivotUtilities.aggregators[\"Sum\"]([\"Tip\"])"));

        DerivedProperties derivedProperties = new DerivedProperties();
        derivedProperties.addAttribute("Smokes",
                new JsFunction("function(record) {return record.Smoker == \"Yes\" ? \"True\" : \"False\";}"));
        tipsCustomAggregatorPivotTable.setDerivedProperties(derivedProperties);
    }
}