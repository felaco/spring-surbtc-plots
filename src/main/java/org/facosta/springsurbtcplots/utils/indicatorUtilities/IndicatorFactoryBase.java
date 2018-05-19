package org.facosta.springsurbtcplots.utils.indicatorUtilities;

import org.facosta.springsurbtcplots.models.entity.Indicator;
import org.facosta.springsurbtcplots.models.entity.IndicatorParam;
import org.facosta.springsurbtcplots.models.entity.IndicatorWrapper;
import org.facosta.springsurbtcplots.repository.IndicatorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class IndicatorFactoryBase
{
    @Autowired
    private IndicatorRepository indicatorRepository;

    private String indicatorName;
    private int paramCount;
    protected String[] paramNames;
    protected float[] paramValues;

    public IndicatorFactoryBase(String indicatorName, int paramCount)
    {
        this.indicatorName = indicatorName;
        this.paramCount = paramCount;
    }

    public IndicatorWrapper build()
    {
        Indicator indicator = indicatorRepository.findByIndicatorName(indicatorName);
        IndicatorWrapper indicatorWrapper = new IndicatorWrapper();
        List<IndicatorParam> list = new ArrayList<>();

        initParams();
        for (int i = 0; i < paramCount; i++)
        {
            IndicatorParam indicatorParam = new IndicatorParam(paramNames[i], paramValues[i]);
            indicatorParam.setIndicatorWrapper(indicatorWrapper);
            list.add(indicatorParam);
        }

        indicatorWrapper.setIndicator(indicator);
        indicatorWrapper.setParams(list);

        return indicatorWrapper;
    }

    /**
     * Init params must initialize the arrays paramNames and paramCount based
     * on the intended indicator
     */
    protected abstract void initParams();
}
