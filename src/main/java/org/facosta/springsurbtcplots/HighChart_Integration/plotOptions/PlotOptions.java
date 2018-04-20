package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlotOptions
{
    private Candlestick candlestick;

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

    @Override
    public String toString()
    {
        return "PlotOptions{" +
                "candlestick=" + candlestick +
                '}';
    }
}
