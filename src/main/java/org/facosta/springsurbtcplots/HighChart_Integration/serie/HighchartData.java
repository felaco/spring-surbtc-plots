package org.facosta.springsurbtcplots.HighChart_Integration.serie;

public class HighchartData
{
    private long x;
    private float open, high, low, close;

    public HighchartData(long x, float open, float high, float low, float close)
    {
        this.x = x;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public HighchartData()
    {
    }

    public long getX()
    {
        return x;
    }

    public void setX(long x)
    {
        this.x = x;
    }

    public float getOpen()
    {
        return open;
    }

    public void setOpen(float open)
    {
        this.open = open;
    }

    public float getHigh()
    {
        return high;
    }

    public void setHigh(float high)
    {
        this.high = high;
    }

    public float getLow()
    {
        return low;
    }

    public void setLow(float low)
    {
        this.low = low;
    }

    public float getClose()
    {
        return close;
    }

    public void setClose(float close)
    {
        this.close = close;
    }
}
