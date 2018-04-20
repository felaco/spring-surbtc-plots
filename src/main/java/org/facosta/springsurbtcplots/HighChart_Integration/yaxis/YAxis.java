package org.facosta.springsurbtcplots.HighChart_Integration.yaxis;

public class YAxis
{
    private Resize resize;

    public YAxis(Resize resize)
    {
        this.resize = resize;
    }

    public YAxis()
    {
        this(new Resize(false));
    }

    public Resize getResize()
    {
        return resize;
    }

    public void setResize(Resize resize)
    {
        this.resize = resize;
    }
}
