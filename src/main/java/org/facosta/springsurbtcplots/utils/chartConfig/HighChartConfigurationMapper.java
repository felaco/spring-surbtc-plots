package org.facosta.springsurbtcplots.utils.chartConfig;

import org.facosta.springsurbtcplots.HighChart_Integration.HighChartChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.IndicatorParam;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.models.entity.UserIndicator;
import org.facosta.springsurbtcplots.models.entity.UserModel;

import java.util.ArrayList;
import java.util.List;

public class HighChartConfigurationMapper implements ChartConfigurationMapper
{

    @Override
    public ChartConfiguration<HighChartChartConfig> map(UserModel userModel)
    {
        HighChartChartConfig config = new HighChartChartConfig();
        List<Serie> series = new ArrayList<>();
        config.setSeries(series);

//        series.add(new Serie.Builder().type("candlestick")
//                                      .id("Bitcoin")
//                                      .name("Precio Bitcoin")
//                                      .build());

        for (UserIndicator indicator : userModel.getUserIndicators())
            series.add(mapSerie(indicator));

        ChartConfiguration<HighChartChartConfig> chartConfiguration;
        chartConfiguration = new ChartConfiguration<>(config);
        return chartConfiguration;
    }

    private Serie mapSerie(UserIndicator userIndicator)
    {
        String type = userIndicator.getIndicatorName();
        if (type.equals("BollingerBand"))
            type = "bb";

        return new Serie.Builder()
                .linkedTo("Bitcoin")
                .name(userIndicator.getIndicatorName())
                .type(type)
                .params(mapParam(userIndicator))
                .build();
    }

    private IndicatorParam mapParam(UserIndicator userIndicator)
    {
        return new IndicatorParam.Builder()
                .period(userIndicator.getPeriod())
                .shortPeriod(userIndicator.getShortPeriod())
                .longPeriod(userIndicator.getLongPeriod())
                .signalPeriod(userIndicator.getSignalPeriod())
                .standardDeviation(userIndicator.getStandardDeviation())
                .build();
    }
}
