@Subscribe
private void onInit(InitEvent event) {
    chart.addGraphItemClickListener(graphItemClickEvent ->
            notifications.create()
                    .withCaption(itemClickEventInfo(graphItemClickEvent))
                    .withContentMode(ContentMode.HTML)
                    .show());
}

private String itemClickEventInfo(Chart.GraphItemClickEvent event) {
    CountryGrowth countryGrowth = (CountryGrowth) event.getEntityNN();
    return String.format("GDP grow in %s (%s): %.1f%%",
            countryGrowth.getCountry(),
            event.getGraphId().substring(5),
            "graph2014".equals(event.getGraphId()) ? countryGrowth.getYear2014() : countryGrowth.getYear2015());
}