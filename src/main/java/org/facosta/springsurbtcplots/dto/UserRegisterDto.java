package org.facosta.springsurbtcplots.dto;

import lombok.Data;
import org.facosta.springsurbtcplots.utils.validation.MatchPassword;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@MatchPassword(baseField = "password", matches = "passwordMatch")
public class UserRegisterDto
{
    @NotNull
    @NotEmpty
    @Size(min = 4, max = 60)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 120)
    private String password;

    @NotNull
    @NotEmpty
    private String passwordMatch;
}
