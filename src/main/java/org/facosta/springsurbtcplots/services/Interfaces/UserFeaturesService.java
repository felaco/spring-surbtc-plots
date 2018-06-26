package org.facosta.springsurbtcplots.services.Interfaces;

import java.util.Map;

public interface UserFeaturesService extends UserService, UserIndicatorService
{
    Map deleteIndicator(String username, String indicatorId);
}
