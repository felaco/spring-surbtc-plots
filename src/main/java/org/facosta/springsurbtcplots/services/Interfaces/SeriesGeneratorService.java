package org.facosta.springsurbtcplots.services.Interfaces;

import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.utils.chartConfig.ChartConfiguration;

public interface SeriesGeneratorService
{
    public Serie generateGenericSeries(String groupBy);
    public ChartConfiguration generateUserSeries(String groupBy, String username);
}
