package org.facosta.springsurbtcplots.HighChart_Integration.serie;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndicatorParam
{
    private Integer period = null; //rsi, ema, macd, bollinger Bands
    private Integer index = null; // macd
    private Integer longPeriod = null; // macd
    private Integer shortPeriod = null; // macd
    private Integer signalPeriod = null; // macd
    private Float standardDeviation = null; // Bollinger Bands
    private String algorithm = null; // Pivot points
    private List<Integer> periods = null; // sctochastic oscilator

    public IndicatorParam()
    {
    }

    public IndicatorParam(Integer period)
    {
        this.period = period;
    }

    private IndicatorParam(Builder builder)
    {
        setPeriod(builder.period);
        setIndex(builder.index);
        setLongPeriod(builder.longPeriod);
        setShortPeriod(builder.shortPeriod);
        setSignalPeriod(builder.signalPeriod);
        setStandardDeviation(builder.standardDeviation);
        setAlgorithm(builder.algorithm);
        setPeriods(builder.periods);
    }

    public Integer getPeriod()
    {
        return period;
    }

    public void setPeriod(Integer period)
    {
        this.period = period;
    }

    public Integer getIndex()
    {
        return index;
    }

    public void setIndex(Integer index)
    {
        this.index = index;
    }

    public Integer getLongPeriod()
    {
        return longPeriod;
    }

    public void setLongPeriod(Integer longPeriod)
    {
        this.longPeriod = longPeriod;
    }

    public Integer getShortPeriod()
    {
        return shortPeriod;
    }

    public void setShortPeriod(Integer shortPeriod)
    {
        this.shortPeriod = shortPeriod;
    }

    public Integer getSignalPeriod()
    {
        return signalPeriod;
    }

    public void setSignalPeriod(Integer signalPeriod)
    {
        this.signalPeriod = signalPeriod;
    }

    public Float getStandardDeviation()
    {
        return standardDeviation;
    }

    public void setStandardDeviation(Float standardDeviation)
    {
        this.standardDeviation = standardDeviation;
    }

    public String getAlgorithm()
    {
        return algorithm;
    }

    public void setAlgorithm(String algorithm)
    {
        this.algorithm = algorithm;
    }

    public List<Integer> getPeriods()
    {
        return periods;
    }

    public void setPeriods(List<Integer> periods)
    {
        this.periods = periods;
    }


    public static final class Builder
    {
        private Integer period;
        private Integer index;
        private Integer longPeriod;
        private Integer shortPeriod;
        private Integer signalPeriod;
        private Float standardDeviation;
        private String algorithm;
        private List<Integer> periods;

        public Builder()
        {
        }

        public Builder period(Integer val)
        {
            period = val;
            return this;
        }

        public Builder index(Integer val)
        {
            index = val;
            return this;
        }

        public Builder longPeriod(Integer val)
        {
            longPeriod = val;
            return this;
        }

        public Builder shortPeriod(Integer val)
        {
            shortPeriod = val;
            return this;
        }

        public Builder signalPeriod(Integer val)
        {
            signalPeriod = val;
            return this;
        }

        public Builder standardDeviation(Float val)
        {
            standardDeviation = val;
            return this;
        }

        public Builder algorithm(String val)
        {
            algorithm = val;
            return this;
        }

        public Builder periods(List<Integer> val)
        {
            periods = val;
            return this;
        }

        public IndicatorParam build()
        {
            return new IndicatorParam(this);
        }
    }
}
