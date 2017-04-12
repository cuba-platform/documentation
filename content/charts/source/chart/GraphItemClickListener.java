serialChart.addGraphItemClickListener(event -> {
        CountryGrowth countryGrowth = (CountryGrowth) event.getEntityNN();
        String message = String.format("GDP grow in %s (%s): %.1f%%",
        countryGrowth.getCountry(),
        event.getGraphId().substring(5),
        "graph2014".equals(event.getGraphId()) ? countryGrowth.getYear2014() : countryGrowth.getYear2015());
        showNotification(message, NotificationType.HUMANIZED_HTML);
});