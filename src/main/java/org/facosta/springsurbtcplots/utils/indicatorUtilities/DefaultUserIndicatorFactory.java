package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.facosta.springsurbtcplots.models.entity.UserIndicator;

public class DefaultUserIndicatorFactory
{
    public static UserIndicator build(String indicatorName)
    {
        switch (indicatorName)
        {
            case "rsi":
                return new UserIndicator(indicatorName, 14);
            case "ema":
                return new UserIndicator(indicatorName, 20);
            case "macd":
                return new UserIndicator(indicatorName,
                                         26, 26,
                                         12, 9);
            case "BollingerBand":
                return new UserIndicator(indicatorName, 20, 2f);
        }
        return new UserIndicator();
    }
}
