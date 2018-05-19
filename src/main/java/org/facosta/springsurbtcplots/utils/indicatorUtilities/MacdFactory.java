package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.springframework.stereotype.Component;


@Component("MACD")
public class MacdFactory extends IndicatorFactoryBase
{
    public MacdFactory()
    {
        super("macd", 4);
    }

    @Override
    protected void initParams()
    {
        paramNames = new String[]{"period", "longPeriod", "shortPeriod", "signalPeriod"};
        paramValues = new float[]{26, 26, 12, 9};
    }
}
