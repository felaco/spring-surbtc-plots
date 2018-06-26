package org.facosta.springsurbtcplots.services.Interfaces;

import org.facosta.springsurbtcplots.models.entity.UserModel;

public interface UserService
{
    UserModel findByUsername(String username);
    UserModel saveUser(UserModel newUser);
    UserModel saveUser(String username, String notEncodedPassword, String... roles);

}
