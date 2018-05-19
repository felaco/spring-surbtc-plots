package org.facosta.springsurbtcplots.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@Entity
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(length = 30, unique = true)
    private String username;

    @NotNull
    @Column(length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<IndicatorWrapper> indicatorWrappers = new ArrayList<>();

    public UserModel()
    {
    }

    public UserModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

}
