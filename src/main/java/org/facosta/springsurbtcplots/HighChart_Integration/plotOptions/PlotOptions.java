package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotOptions
{
    private Candlestick candlestick;
    private OptionSerie series = new OptionSerie();

    public PlotOptions(Candlestick candlestick)
    {
        this.candlestick = candlestick;
    }

    public PlotOptions()
    {
        this(new Candlestick());
    }

    public Candlestick getCandlestick()
    {
        return candlestick;
    }

    public void setCandlestick(Candlestick candlestick)
    {
        this.candlestick = candlestick;
    }

    public OptionSerie getSeries()
    {
        return series;
    }

    public void setSeries(OptionSerie serie)
    {
        this.series = serie;
    }

    @Override
    public String toString()
    {
        return "PlotOptions{" +
                "candlestick=" + candlestick +
                ", series=" + series +
                '}';
    }
}
