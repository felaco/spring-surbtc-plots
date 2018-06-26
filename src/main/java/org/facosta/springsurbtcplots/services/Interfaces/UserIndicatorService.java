package org.facosta.springsurbtcplots.services.Interfaces;

import org.facosta.springsurbtcplots.models.entity.UserIndicator;

import java.util.List;

public interface UserIndicatorService
{
    UserIndicator save(UserIndicator userIndicator);
    UserIndicator findUserIndicatorById(String id);
    void deleteUserById(String id);
    void deleteThese(List<UserIndicator> userIndicatorList);
}
