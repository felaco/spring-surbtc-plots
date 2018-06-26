package org.facosta.springsurbtcplots.models.entity;

import lombok.Data;
import org.apache.commons.beanutils.BeanMap;
import org.facosta.springsurbtcplots.utils.indicatorUtilities.Source;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Data
@Document
public class UserIndicator implements Serializable
{
    @Id
    private String id;

    @NotNull
    private String indicatorName;

    private Integer period;
    private Float standardDeviation;
    private Integer longPeriod;
    private Integer shortPeriod;
    private Integer signalPeriod;

    //Stores which ohlc column is used to calculate the indicator.
    private Source source = Source.CLOSE;

    public UserIndicator()
    {
    }

    // Constructor for ema and rsi indicators
    public UserIndicator(@NotNull String indicatorName, int period)
    {
        this.indicatorName = indicatorName;
        this.period = period;
    }

    // Constructor for macd
    public UserIndicator(@NotNull String indicatorName, int period,
                         int longPeriod, int shortPeriod, int signalPeriod)
    {
        this.indicatorName = indicatorName;
        this.period = period;
        this.longPeriod = longPeriod;
        this.shortPeriod = shortPeriod;
        this.signalPeriod = signalPeriod;
    }

    // Constructor for Bollinger Bands
    public UserIndicator(@NotNull String indicatorName, int period, float standardDeviation)
    {
        this.indicatorName = indicatorName;
        this.period = period;
        this.standardDeviation = standardDeviation;
    }

    /**
     * returns a string representing the instance like it were a function call ignoring
     * the null attributes.
     *
     * UserIndicator UserIndicator = new Indicator("BollingerBands", 14, 2);
     *
     * UserIndicator.stringRepresentation();
     * would returns "(14, 2)"
     *
     * and
     * UserIndicator.stringRepresentation(true);
     * would returns "BollingerBands(14, 2)"
     * @param includeIndicatorName whether includes the indicatorName at the beginning
     * @return String
     */
    public String stringRepresentation(boolean includeIndicatorName)
    {
        List<String> skipKeys = new ArrayList<String>(Arrays.asList(
                "class", "indicatorName", "source", "valid", "id"));

        BeanMap beanMap = new BeanMap(this);
        Iterator<String> it = beanMap.keyIterator();
        StringBuilder stringBuilder = new StringBuilder();

        if (includeIndicatorName)
            stringBuilder.append(beanMap.get("indicatorName"));

        stringBuilder.append('(');
        String commaChar = "";
        while (it.hasNext())
        {
            String key = it.next();
            if (skipKeys.contains(key)) continue;

            Object value = beanMap.get(key);
            if (value != null)
            {
                stringBuilder.append(commaChar);
                stringBuilder.append(value);
                commaChar = ", ";
            }
        }

        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    public String stringRepresentation()
    {
        return stringRepresentation(false);
    }

    public boolean isValid()
    {
        List<String> skipKeys = new ArrayList<String>(Arrays.asList(
                "class", "indicatorName", "source", "valid"));

        BeanMap beanMap = new BeanMap(this);
        Iterator<String> it = beanMap.keyIterator();

        while (it.hasNext())
        {
            String key = it.next();
            if (skipKeys.contains(key)) continue;

            Object value = beanMap.get(key);
            if (value != null)
                return true; // valid instance
        }
        return false; // invalid instance
    }
}
