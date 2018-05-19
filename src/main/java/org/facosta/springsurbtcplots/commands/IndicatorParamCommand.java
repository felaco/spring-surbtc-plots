package org.facosta.springsurbtcplots.commands;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;

@Getter
@Setter
public class IndicatorParamCommand
{
    private String paramName;
    private float paramValue;

    public IndicatorParamCommand(String paramName, float paramValue)
    {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public IndicatorParamCommand()
    {
    }

    public String toBuilderString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        decimalFormat.setMaximumFractionDigits(1);
        return decimalFormat.format(paramValue);
    }
}
