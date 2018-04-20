package org.facosta.springsurbtcplots.HighChart_Integration.plotOptions;

public class Marker
{
    private boolean enabled = true;

    public Marker(boolean enabled)
    {
        this.enabled = enabled;
    }

    public Marker()
    {
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }
}
