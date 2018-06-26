package org.facosta.springsurbtcplots.HighChart_Integration;

import org.facosta.springsurbtcplots.HighChart_Integration.plotOptions.PlotOptions;
import org.facosta.springsurbtcplots.HighChart_Integration.rangeSelector.RangeSelector;
import org.facosta.springsurbtcplots.HighChart_Integration.serie.Serie;
import org.facosta.springsurbtcplots.HighChart_Integration.yaxis.YAxis;

import java.util.List;

public class HighChartChartConfig
{
    private PlotOptions plotOptions;
    private RangeSelector rangeSelector;
    private YAxis yAxis;
    private List<Serie> series;

    public HighChartChartConfig()
    {
        plotOptions = new PlotOptions();
        rangeSelector = new RangeSelector();
        yAxis = new YAxis();
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

    public YAxis getyAxis()
    {
        return yAxis;
    }

    public void setyAxis(YAxis yAxis)
    {
        this.yAxis = yAxis;
    }
}
