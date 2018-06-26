package org.facosta.springsurbtcplots.utils.chartConfig;

public class ChartConfiguration<Config>
{
    private final Config config;

    public ChartConfiguration(Config config)
    {
        this.config = config;
    }

    public Config get()
    {
        return config;
    }
}
