package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.commands.UserCommand;
import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.IndicatorsService;
import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.UserIndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
    private UserIndicatorsService userIndicatorsService;
    private IndicatorsService indicatorsService;

    @Autowired
    public IndexController(UserIndicatorsService userIndicatorsService, IndicatorsService indicatorsService)
    {
        this.userIndicatorsService = userIndicatorsService;
        this.indicatorsService = indicatorsService;
    }

    @GetMapping("/")
    @PreAuthorize("permitAll()")
    public String index(Model model, Authentication authentication)
    {
        if (authentication != null)
        {
            UserCommand userCommand = userIndicatorsService.findUserByName(authentication.getName());
            model.addAttribute("user", userCommand);
            model.addAttribute("indicators", indicatorsService.findAllIndicators());
        }
        return "index.html";
    }

}
