package org.facosta.springsurbtcplots.HighChart_Integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.facosta.springsurbtcplots.HighChart_Integration.plotOptions.PlotOptions;
import org.facosta.springsurbtcplots.HighChart_Integration.rangeSelector.RangeSelector;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;

import java.util.List;

public class ChartConfig
{
    private PlotOptions plotOptions;
    private RangeSelector rangeSelector;
    private List<Serie> series;

    public ChartConfig()
    {
        plotOptions = new PlotOptions();
        rangeSelector = new RangeSelector();
    }

    public PlotOptions getPlotOptions()
    {
        return plotOptions;
    }

    public void setPlotOptions(PlotOptions plotOptions)
    {
        this.plotOptions = plotOptions;
    }

    public RangeSelector getRangeSelector()
    {
        return rangeSelector;
    }

    public void setRangeSelector(RangeSelector rangeSelector)
    {
        this.rangeSelector = rangeSelector;
    }

    public List<Serie> getSeries()
    {
        return series;
    }

    public void setSeries(List<Serie> series)
    {
        this.series = series;
    }
}
