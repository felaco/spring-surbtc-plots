package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.HighChart_Integration.ChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.services.Interfaces.SeriesGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HighChartController
{
    private SeriesGeneratorService seriesGeneratorService;

    @Autowired
    public HighChartController(SeriesGeneratorService seriesGeneratorService)
    {
        this.seriesGeneratorService = seriesGeneratorService;
    }

    @GetMapping("/highchart")
    public ChartConfig getData()
    {
        ChartConfig chartConfig = new ChartConfig();
        List<Serie> series = new ArrayList<>();
        series.add(seriesGeneratorService.generateGenericSeries("1D"));
        chartConfig.setSeries(series);

        return chartConfig;
    }
}
