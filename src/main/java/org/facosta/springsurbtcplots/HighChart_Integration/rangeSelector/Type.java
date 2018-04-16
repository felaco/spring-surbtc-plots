package org.facosta.springsurbtcplots.HighChart_Integration.rangeSelector;

public enum Type
{
    DAY("day"), MONTH("month"), HOUR("hour"), WEEK("week"), YEAR("year");

    private String typeStr;

    Type(String typeStr)
    {
        this.typeStr = typeStr;
    }

    public String getTypeStr()
    {
        return typeStr;
    }
}
