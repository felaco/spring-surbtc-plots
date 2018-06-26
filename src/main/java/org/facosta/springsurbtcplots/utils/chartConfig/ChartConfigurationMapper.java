package org.facosta.springsurbtcplots.utils.chartConfig;

import org.facosta.springsurbtcplots.models.entity.UserModel;

public interface ChartConfigurationMapper
{
    ChartConfiguration map(UserModel userModel);
}
