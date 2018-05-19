package org.facosta.springsurbtcplots.commands.converter;

import org.facosta.springsurbtcplots.commands.IndicatorCommand;
import org.facosta.springsurbtcplots.commands.IndicatorParamCommand;
import org.facosta.springsurbtcplots.commands.UserCommand;
import org.facosta.springsurbtcplots.models.entity.IndicatorParam;
import org.facosta.springsurbtcplots.models.entity.IndicatorWrapper;
import org.facosta.springsurbtcplots.models.entity.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserCommandConverter
{
    public static UserCommand fromUserModel(UserModel userModel)
    {
        UserCommand userCommand = new UserCommand(userModel.getUsername());
        userCommand.setIndicatorCommandList(indicatorWrapper2IndicatorCommand(
                userModel.getIndicatorWrappers()));

        return userCommand;
    }

    public static List<IndicatorCommand> indicatorWrapper2IndicatorCommand(List<IndicatorWrapper> indicatorWrapper)
    {
        if (indicatorWrapper == null || indicatorWrapper.isEmpty())
            return new ArrayList<>();

        return indicatorWrapper.stream()
                               .map(UserCommandConverter::indicatorWrapper2IndicatorCommand)
                               .collect(Collectors.toList());
    }

    public static IndicatorCommand indicatorWrapper2IndicatorCommand(IndicatorWrapper indicatorWrapper)
    {
        return new IndicatorCommand(indicatorWrapper.getIndicator().getIndicatorName(),
                                    indicatorWrapper.getSource().toString(),
                                    indicatorParam2IndicatorParamCommand(indicatorWrapper.getParams()));
    }

    public static List<IndicatorParamCommand> indicatorParam2IndicatorParamCommand(List<IndicatorParam> indicatorParams)
    {
        if (indicatorParams == null || indicatorParams.isEmpty())
            return new ArrayList<>();

        List<IndicatorParamCommand> indicatorParamCommands = new ArrayList<>();
        for (IndicatorParam indicatorParam : indicatorParams)
        {
            IndicatorParamCommand param = new IndicatorParamCommand(indicatorParam.getParamName(),
                                                                    indicatorParam.getValue());
            indicatorParamCommands.add(param);
        }

        return indicatorParamCommands;

    }
}
