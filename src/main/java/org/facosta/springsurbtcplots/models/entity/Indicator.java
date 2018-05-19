package org.facosta.springsurbtcplots.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Indicator
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(length = 30)
    private String indicatorName;

    @NotNull
    private int param_count;

    public Indicator()
    {
    }

    public Indicator(@NotNull String indicatorName, @NotNull int param_count)
    {
        this.indicatorName = indicatorName;
        this.param_count = param_count;
    }

}
