pieChart.setWidth("700px");
pieChart.setTitleField("description")
        .setValueField("value")
        .setStartAngle(312)
        .setLegend(new Legend()
                .setMarkerType(MarkerType.CIRCLE)
                .setPosition(LegendPosition.RIGHT)
                .setMarginRight(80))
        .addLabels(
                new Label()
                    .setText("Sample Chart")
                    .setSize(26)
                    .setBold(true)
                    .setAlign(Align.CENTER),
                new Label()
                    .setText("extra information")
                    .setAlign(Align.RIGHT))
        .setLabelTickColor(Color.GOLDENROD)
        .setColors(Arrays.asList(
                    Color.valueOf("#446493"),
                    Color.valueOf("#5E3D2C"),
                    Color.valueOf("#D0A557")))
        .setDataProvider(dataProvider);