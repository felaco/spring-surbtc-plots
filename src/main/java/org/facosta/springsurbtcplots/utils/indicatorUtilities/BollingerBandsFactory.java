package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.springframework.stereotype.Component;

@Component("BOLLINGERBAND")
public class BollingerBandsFactory extends IndicatorFactoryBase
{
    public BollingerBandsFactory()
    {
        super("bollingerBand", 2);
    }


    @Override
    protected void initParams()
    {
        paramNames = new String[]{"period", "standardDeviation"};
        paramValues = new float[]{20, 2};
    }
}
