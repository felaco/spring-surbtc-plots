package org.facosta.springsurbtcplots.HighChart_Integration.yaxis;

public class Resize
{
    private boolean enabled;

    public Resize(boolean enabled)
    {
        this.enabled = enabled;
    }

    public Resize()
    {
        this(false);
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "Resize{" +
                "enabled=" + enabled +
                '}';
    }
}
