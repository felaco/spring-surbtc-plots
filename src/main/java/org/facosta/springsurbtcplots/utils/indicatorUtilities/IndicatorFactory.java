package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.facosta.springsurbtcplots.config.ApplicationContextProvider;
import org.facosta.springsurbtcplots.models.entity.IndicatorWrapper;
import org.springframework.context.ApplicationContext;

/**
 * Convenience class to make easier te creation of IndicatorWrapper entity
 */
public class IndicatorFactory
{

    /**
     * Creates a new default indicatorWrapper entity based on the indicatorName param
     * usage example:
     *<pre>
     * {@code
     * IndicatorWrapper indicatorWrapper = IndicatorFactory.buildIndicator("rsi");
     * indicatorWrapper.setUser(desiredUser);
     * }
     *</pre>
     * will return:
     * IndicatorWrapper(id=someid, user=null,
     *                  indicator=Indicator(id=someid, indicatorName='rsi', param_count=1),
     *                  params=[IndicatorParam{id=someid, value=14.0, paramName='period'}],
     *                  source=MEAN)
     *
     *so, you'll still need to set the desired user.
     * @param indicatorName: Indicator expected (rsi for example)
     * @return IndicatorWrapper
     */
    public static IndicatorWrapper buildIndicator(String indicatorName)
    {
        ApplicationContext context = ApplicationContextProvider.getCurrentContext();
        IndicatorFactoryBase factory = context.getBean(indicatorName.toUpperCase(),
                                                       IndicatorFactoryBase.class);

        return factory.build();
    }
}
