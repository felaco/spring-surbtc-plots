package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.springframework.stereotype.Component;

@Component("EMA")
public class EmaFactory extends IndicatorFactoryBase
{

    public EmaFactory()
    {
        super("ema", 1);
    }


    @Override
    protected void initParams()
    {
        paramNames = new String[]{"period"};
        paramValues = new float[]{20};
    }
}
