package org.facosta.springsurbtcplots.models.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class SupportedIndicators implements Serializable
{
    @Id
    private String id;
    private int paramCount;
    private String indicatorName;
    private String[] paramNames;

    public SupportedIndicators(String indicatorName, String[] paramNames)
    {
        this.indicatorName = indicatorName;
        this.paramNames = paramNames;
        this.paramCount = paramNames.length;
    }
}
