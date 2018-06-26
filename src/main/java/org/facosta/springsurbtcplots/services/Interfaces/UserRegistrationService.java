package org.facosta.springsurbtcplots.services.Interfaces;

import org.facosta.springsurbtcplots.dto.UserRegisterDto;
import org.facosta.springsurbtcplots.utils.errors.UserExistsException;

public interface UserRegistrationService
{
    boolean registerNewUser(UserRegisterDto user);
}
