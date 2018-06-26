package org.facosta.springsurbtcplots.models.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
public class Role implements Serializable
{
    @NotNull
    private String name;

    public Role()
    {
    }

    public Role(@NotNull String name)
    {
        this.name = name;
    }

}
