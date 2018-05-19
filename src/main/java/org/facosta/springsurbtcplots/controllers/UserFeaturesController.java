package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.commands.IndicatorCommand;
import org.facosta.springsurbtcplots.commands.UserCommand;
import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.UserIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserFeaturesController
{
    private UserIndicatorsService userIndicatorsService;

    @Autowired
    public UserFeaturesController(UserIndicatorsService userIndicatorsService)
    {
        this.userIndicatorsService = userIndicatorsService;
    }

    @Secured("ROLE_USER")
    @GetMapping("indicators/{username}/{indicatorIndex}")
    public String editUserIndicator(@PathVariable("username") String username,
                                    @PathVariable("indicatorIndex") int indicatorIndex,
                                    Model model)
    {
        UserCommand userCommand = userIndicatorsService.findUserByName(username);
        IndicatorCommand indicatorCommand;
        indicatorCommand = userCommand.getIndicatorCommandList().get(indicatorIndex);

        model.addAttribute("indicator", indicatorCommand);
        return "editIndicator.html";
    }
}
