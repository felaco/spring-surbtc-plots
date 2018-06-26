//package org.facosta.springsurbtcplots.controllers;
//
//import org.facosta.springsurbtcplots.commands.UserCommand;
//import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.IndicatorsService;
//import org.facosta.springsurbtcplots.services.indicatorsCrud.interfaces.UserIndicatorsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class IndexController
//{
//    private UserIndicatorsService userIndicatorsService;
//    private IndicatorsService indicatorsService;
//
//    @Autowired
//    public IndexController(UserIndicatorsService userIndicatorsService, IndicatorsService indicatorsService)
//    {
//        this.userIndicatorsService = userIndicatorsService;
//        this.indicatorsService = indicatorsService;
//    }
//
//    @GetMapping("/")
//    @PreAuthorize("permitAll()")
//    public String index(Model model, Authentication authentication)
//    {
//        if (authentication != null)
//        {
//            UserCommand userCommand = userIndicatorsService.findUserByName(authentication.getName());
//            model.addAttribute("user", userCommand);
//            model.addAttribute("indicators", indicatorsService.findAllIndicators());
//        }
//        return "index.html";
//    }
//
//}
package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.models.entity.SupportedIndicators;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.repository.SupportedIndicatorsRepository;
import org.facosta.springsurbtcplots.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class IndexController
{
    private UserService userService;
    private SupportedIndicatorsRepository supportedIndicatorsRepository;

    @Autowired
    public IndexController(UserService userService, SupportedIndicatorsRepository supportedIndicatorsRepository)
    {
        this.userService = userService;
        this.supportedIndicatorsRepository = supportedIndicatorsRepository;
    }

    @GetMapping("/")
    public String getIndex(Principal principal, Model model)
    {
        if (principal != null)
        {
            UserModel user = userService.findByUsername(principal.getName());
            List<SupportedIndicators> supportedIndicators;
            supportedIndicators = supportedIndicatorsRepository.findAll();

            model.addAttribute("user", user);
            model.addAttribute("supportedIndicators", supportedIndicators);
        }

        return "index";
    }
}
