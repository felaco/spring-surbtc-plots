package org.facosta.springsurbtcplots.controllers;

import lombok.extern.slf4j.Slf4j;
import org.facosta.springsurbtcplots.commands.IndicatorCommand;
import org.facosta.springsurbtcplots.commands.UserCommand;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.UserRepository;
import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.UserIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Slf4j
@RestController
public class UserFeaturesRestController
{
    private UserIndicatorsService userIndicatorsService;

    @Autowired
    public UserFeaturesRestController(UserIndicatorsService userIndicatorsService)
    {
        this.userIndicatorsService = userIndicatorsService;
    }

    @PostMapping(value = "/api/indicators", produces = "application/json")
    @Secured("ROLE_USER")
    public String insertNewUserIndicator(Principal principal, @RequestParam("paramName") String paramName)
    {
        log.info("userValue : " + principal.getName());
        log.info("paramName : " +paramName);
        IndicatorCommand indicatorCommand;
        indicatorCommand = userIndicatorsService.insertDefaultIndicator(principal.getName(), paramName);

        return indicatorCommand.toJson();
    }

    @GetMapping(value = "/api/loggedUser", produces = "application/json")
    @Secured("ROLE_USER")
    public String getCurrentLoggedUser(Principal principal)
    {
        return "{\"username\":\"" + principal.getName() +"\"}";
    }

    @GetMapping(value = "/api/indicators/{username}/{indicatorIndex}")
    @Secured("ROLE_USER")
    public IndicatorCommand getUserIndicatorCommandFromId(@PathVariable("username") String userName,
                                                          @PathVariable("indicatorIndex") int index)
    {
        UserCommand userCommand = userIndicatorsService.findUserByName(userName);
        return userCommand.getIndicatorCommandList().get(index);
    }
}
