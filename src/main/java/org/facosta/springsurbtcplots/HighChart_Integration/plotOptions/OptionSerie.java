package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

public class OptionSerie
{
    private int turboThreshold;

    public OptionSerie(int turboThreshold)
    {
        this.turboThreshold = turboThreshold;
    }

    public OptionSerie()
    {
        turboThreshold = 0;
    }

    public int getTurboThreshold()
    {
        return turboThreshold;
    }

    public void setTurboThreshold(int turboThreshold)
    {
        this.turboThreshold = turboThreshold;
    }
}
