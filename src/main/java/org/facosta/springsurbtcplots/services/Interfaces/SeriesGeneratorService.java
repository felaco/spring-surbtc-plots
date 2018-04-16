package org.facosta.springsurbtcplots.services.Interfaces;

import org.facosta.springsurbtcplots.HighChart_Integration.ChartConfig;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;

public interface SeriesGeneratorService
{
    public Serie generateGenericSeries(String groupBy);
    public Serie generateUserSeries(String groupBy, ChartConfig config);
}
