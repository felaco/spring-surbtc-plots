package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.HighChart_Integration.HighChartChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.services.Interfaces.SeriesGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
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

    @GetMapping("/api/highchart")
    public HighChartChartConfig getData(Principal loggedUser)
    {
        HighChartChartConfig chartConfig;

        if (loggedUser != null)
        {
            chartConfig = (HighChartChartConfig) seriesGeneratorService
                    .generateUserSeries("1D", loggedUser.getName())
                    .get();
        }
        else
        {
            chartConfig = new HighChartChartConfig();
            List<Serie> series = new ArrayList<>();
            series.add(seriesGeneratorService.generateGenericSeries("1D"));
            chartConfig.setSeries(series);
        }

        return chartConfig;
    }


}
