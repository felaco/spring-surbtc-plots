package org.facosta.springsurbtcplots.HighChart_Integration.serie;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.facosta.springsurbtcplots.HighChart_Integration.plotOptions.Marker;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Serie
{
    private String type;
    private String name=null;
    private String id = null;
    private String linkedTo = null;
    private IndicatorParam params = null;
    private List<HighchartData> data;
    private Marker marker = null;



    public Serie(String type, String name)
    {
        marker = new Marker(false);
        this.type = type;
        this.name = name;
    }

    public Serie(String type)
    {
        this.type = type;
        marker = new Marker(false);
    }

    public Serie()
    {
        this("candlestick");
    }

    private Serie(Builder builder)
    {
        setMarker(new Marker(false));
        setType(builder.type);
        setName(builder.name);
        setId(builder.id);
        setLinkedTo(builder.linkedTo);
        setParams(builder.params);
        setData(builder.data);
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<HighchartData> getData()
    {
        return data;
    }

    public void setData(List<HighchartData> data)
    {
        this.data = data;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getLinkedTo()
    {
        return linkedTo;
    }

    public void setLinkedTo(String linkedTo)
    {
        this.linkedTo = linkedTo;
    }

    public IndicatorParam getParams()
    {
        return params;
    }

    public void setParams(IndicatorParam params)
    {
        this.params = params;
    }

    public Marker getMarker()
    {
        return marker;
    }

    public void setMarker(Marker marker)
    {
        this.marker = marker;
    }

    public static final class Builder
    {
        private String type;
        private String name;
        private String id;
        private String linkedTo;
        private IndicatorParam params;
        private List<HighchartData> data;

        public Builder()
        {
        }

        public Builder type(String val)
        {
            type = val;
            return this;
        }

        public Builder name(String val)
        {
            name = val;
            return this;
        }

        public Builder id(String val)
        {
            id = val;
            return this;
        }

        public Builder linkedTo(String val)
        {
            linkedTo = val;
            return this;
        }

        public Builder params(IndicatorParam val)
        {
            params = val;
            return this;
        }

        public Builder data(List<HighchartData> val)
        {
            data = val;
            return this;
        }

        public Serie build()
        {
            return new Serie(this);
        }
    }
}
