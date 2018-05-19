package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.springframework.stereotype.Component;

@Component("RSI")
public class RsiFactory extends IndicatorFactoryBase
{
    public RsiFactory()
    {
        super("rsi", 1);
    }

    @Override
    protected void initParams()
    {
        paramNames = new String[]{"period"};
        paramValues = new float[]{14};
    }
}
