package org.facosta.springsurbtcplots.commands;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserCommand
{
    private String userName;
    private List<IndicatorCommand> indicatorCommandList;

    public UserCommand(String userName)
    {
        this.userName = userName;
    }
}
