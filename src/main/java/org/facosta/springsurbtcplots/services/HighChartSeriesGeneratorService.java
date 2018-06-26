package org.facosta.springsurbtcplots.services;

import org.facosta.springsurbtcplots.HighChart_Integration.HighChartChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.HighchartData;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.services.Interfaces.GetRequestHandlerService;
import org.facosta.springsurbtcplots.services.Interfaces.SeriesGeneratorService;
import org.facosta.springsurbtcplots.services.Interfaces.UserFeaturesService;
import org.facosta.springsurbtcplots.utils.DataJsonParse;
import org.facosta.springsurbtcplots.utils.chartConfig.ChartConfiguration;
import org.facosta.springsurbtcplots.utils.chartConfig.ChartConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HighchartGenerator")
public class HighChartSeriesGeneratorService implements SeriesGeneratorService
{
    private GetRequestHandlerService requester;
    private UserFeaturesService userFeaturesService;
    private ChartConfigurationMapper configurationMapper;

    @Autowired
    public HighChartSeriesGeneratorService(GetRequestHandlerService requester, UserFeaturesService userFeaturesService, ChartConfigurationMapper configurationMapper)
    {
        this.requester = requester;
        this.userFeaturesService = userFeaturesService;
        this.configurationMapper = configurationMapper;
    }

    @Override
    public Serie generateGenericSeries(String groupBy)
    {
        Serie serie = new Serie("candlestick");
        List<HighchartData> data = DataJsonParse.toHighChartData(requester.getHttpRequest(groupBy));
        serie.setData(data);
        serie.setName("Precio Bitcoin");
        serie.setId("Bitcoin");
        return serie;
    }

    @Override
    public ChartConfiguration generateUserSeries(String groupBy, String username)
    {
        ChartConfiguration config = mapUsernameToConfig(username);
        HighChartChartConfig chartConfig = (HighChartChartConfig) config.get();
        Serie mainSerie = generateGenericSeries(groupBy);

        chartConfig.getSeries().add(0, mainSerie);
        return new ChartConfiguration<>(chartConfig);
    }

    private ChartConfiguration mapUsernameToConfig(String username)
    {
        UserModel userModel = userFeaturesService.findByUsername(username);
        return configurationMapper.map(userModel);
    }
}
