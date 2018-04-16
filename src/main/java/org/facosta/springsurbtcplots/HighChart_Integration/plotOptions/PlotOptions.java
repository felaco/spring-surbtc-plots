package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

public class PlotOptions
{
    String color;
    String upColor;

    public PlotOptions(String color, String upColor)
    {
        this.color = color;
        this.upColor = upColor;
    }

    public PlotOptions()
    {
        this("#f33f3f", "#5af127");
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getUpColor()
    {
        return upColor;
    }

    public void setUpColor(String upColor)
    {
        this.upColor = upColor;
    }

    @Override
    public String toString()
    {
        return "PlotOptions{" +
                "color='" + color + '\'' +
                ", upColor='" + upColor + '\'' +
                '}';
    }
}
