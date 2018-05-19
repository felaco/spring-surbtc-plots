package org.facosta.springsurbtcplots.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;


@Data
@EqualsAndHashCode(exclude = {"userModels"})
@ToString(exclude = "userModels")
@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<UserModel> userModels = new HashSet<>();

    public Role()
    {
    }

    public Role(@NotNull String name)
    {
        this.name = name;
    }

}
