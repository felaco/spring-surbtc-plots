package org.facosta.springsurbtcplots.HighChart_Integration.serie;

public class Serie
{
    private String serie;
    private String name="";
    private String data;

    public Serie(String serie, String name)
    {
        this.serie = serie;
        this.name = name;
    }

    public Serie(String serie)
    {
        this.serie = serie;
    }

    public Serie()
    {
        this("candlestick");
    }

    public String getSerie()
    {
        return serie;
    }

    public void setSerie(String serie)
    {
        this.serie = serie;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
}
