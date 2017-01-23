public class PivotSampleScreen extends AbstractWindow {

    @Inject
    private PivotTable tipsCustomAggregatorPivotTable;

    @Override
    public void init(Map<String, Object> params) {
        tipsCustomAggregatorPivotTable.setSortersFunction(
                new JsFunction("function(attr){if(attr == \"Day\"){return $.pivotUtilities.sortAs([\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\",\"Sun\"]);}}")

        tipsCustomAggregatorPivotTable.getAggregation().setFunction(
                new JsFunction("$.pivotUtilities.aggregators[\"Sum\"]([\"Tip\"])"));

        DerivedProperties derivedProperties = new DerivedProperties();
        derivedProperties.addAttribute("Smoke",
                new JsFunction("function(record) {return record.smoker == \"Yes\" ? \"True\" : \"False\";}"));
        tipsCustomAggregatorPivotTable.setDerivedProperties(derivedProperties);
    }
}