package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

public class Candlestick
{
    private String color;
    private String upColor;
    private String lineColor;
    private String upLineColor;

    public Candlestick(String color, String upColor)
    {
        this.color = color;
        this.upColor = upColor;
        lineColor = color;
        upLineColor = upColor;
    }

    public Candlestick()
    {
        this("#dc3545", "#28a745");
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

    public String getLineColor()
    {
        return lineColor;
    }

    public void setLineColor(String lineColor)
    {
        this.lineColor = lineColor;
    }

    public String getUpLineColor()
    {
        return upLineColor;
    }

    public void setUpLineColor(String upLineColor)
    {
        this.upLineColor = upLineColor;
    }

    @Override
    public String toString()
    {
        return "Candlestick{" +
                "color='" + color + '\'' +
                ", upColor='" + upColor + '\'' +
                '}';
    }
}
