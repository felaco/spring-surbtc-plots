package org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces;

import org.facosta.springsurbtcplots.commands.IndicatorCommand;
import org.facosta.springsurbtcplots.commands.UserCommand;

public interface UserIndicatorsService
{
    UserCommand findUserByName(String name);
    IndicatorCommand insertDefaultIndicator(String userName, String indicatorName);
}
