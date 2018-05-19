package org.facosta.springsurbtcplots.models.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(exclude = {"indicatorWrapper"})
@ToString(exclude = "indicatorWrapper")
@Entity
public class IndicatorParam
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private float value;

    @NotNull
    @Column(length = 30)
    private String paramName;

    @ManyToOne(fetch = FetchType.LAZY)
    private IndicatorWrapper indicatorWrapper;

    public IndicatorParam()
    {
    }

    public IndicatorParam(@NotNull String paramName, @NotNull float value)
    {
        this.value = value;
        this.paramName = paramName;
    }

}
