package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.models.entity.UserIndicator;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.services.Interfaces.UserFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Secured("ROLE_USER")
@Controller
public class UserFeaturesController
{
    private UserFeaturesService userFeatures;

    @Autowired
    public UserFeaturesController(UserFeaturesService userFeatures)
    {
        this.userFeatures = userFeatures;
    }

    @GetMapping("indicators/{username}/{indicatorId}")
    public String getUserIndicatorView(@PathVariable("username") String username,
                                        @PathVariable("indicatorId") String indicatorId,
                                        Model model)
    {
        UserModel user = userFeatures.findByUsername(username);
        UserIndicator userIndicator = null;

        for (UserIndicator indicator : user.getUserIndicators())
            if (indicator.getId().equals(indicatorId))
            {
                userIndicator = indicator;
                break;
            }

        if (userIndicator == null)
            model.addAttribute("error", true);
        else
            model.addAttribute("error", false);

        model.addAttribute("indicator", userIndicator);
        model.addAttribute("username", username);
        model.addAttribute("indicatorId", indicatorId);

        return "editIndicator";
    }

    @PostMapping("indicators/{username}/{indicatorId}")
    public String postUserIndicatorView(@ModelAttribute UserIndicator indicator,
                                        @PathVariable("username") String username,
                                        @PathVariable("indicatorId") String indicatorId)
    {
        if(indicator.getPeriod() != null && indicator.getPeriod()< 1)
            indicator.setPeriod(1);

        if(indicator.getStandardDeviation() != null && indicator.getStandardDeviation()< 1)
            indicator.setStandardDeviation(1f);

        if(indicator.getLongPeriod() !=null && indicator.getPeriod() < 1)
            indicator.setLongPeriod(1);

        if(indicator.getShortPeriod() != null && indicator.getShortPeriod() < 1)
            indicator.setShortPeriod(1);

        if(indicator.getSignalPeriod() != null && indicator.getSignalPeriod() < 1)
            indicator.setSignalPeriod(1);

        UserModel user = userFeatures.findByUsername(username);
        for (UserIndicator userIndicator : user.getUserIndicators())
        {
            if (userIndicator.getId().equals(indicatorId))
            {
                indicator.setId(userIndicator.getId());
                indicator.setSource(userIndicator.getSource());
                indicator.setIndicatorName(userIndicator.getIndicatorName());
                userFeatures.save(indicator);
            }
        }
        return "redirect:/";
    }
}
