package org.facosta.springsurbtcplots.models.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Data
@Document
public class UserModel implements Serializable
{
    @Id
    private String id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @DBRef(lazy = false)
    private List<UserIndicator> userIndicators = new ArrayList<>();

    private Collection<Role> roles = new HashSet<>();


    public UserModel()
    {
    }

    public UserModel(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

}
