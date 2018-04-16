package org.facosta.springsurbtcplots.services;

import org.facosta.springsurbtcplots.HighChart_Integration.ChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.services.Interfaces.GetRequestHandlerService;
import org.facosta.springsurbtcplots.services.Interfaces.SeriesGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesGeneratorServiceImp implements SeriesGeneratorService
{
    private GetRequestHandlerService requester;

    @Autowired
    public SeriesGeneratorServiceImp(GetRequestHandlerService requester)
    {
        this.requester = requester;
    }

    @Override
    public Serie generateGenericSeries(String groupBy)
    {
        Serie serie = new Serie("candlestick");
        serie.setData(requester.getHttpRequest(groupBy));
        return serie;
    }

    @Override
    public Serie generateUserSeries(String groupBy, ChartConfig config)
    {
        return null;
    }
}
