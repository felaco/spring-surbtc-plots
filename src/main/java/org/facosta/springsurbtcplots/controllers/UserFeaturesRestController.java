package org.facosta.springsurbtcplots.controllers;


import org.facosta.springsurbtcplots.models.entity.UserIndicator;
import org.facosta.springsurbtcplots.models.entity.UserModel;
import org.facosta.springsurbtcplots.services.Interfaces.UserFeaturesService;
import org.facosta.springsurbtcplots.utils.indicatorUtilities.DefaultUserIndicatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Secured("ROLE_USER")
@RestController
public class UserFeaturesRestController
{
    private UserFeaturesService userFeatures;

    @Autowired
    public UserFeaturesRestController(UserFeaturesService userFeatures)
    {
        this.userFeatures = userFeatures;
    }

    @GetMapping("/api/loggedUser")
    public Map getLoggedUser(Principal principal)
    {
        Map<String, String> response = new HashMap<>();
        String username;

        if (principal == null)
            username = "";
        else
            username = principal.getName();


        response.put("username", username);

        return response;
    }

    @PostMapping(value = "/api/indicators", produces = "application/json")
    public ResponseEntity<Map> postIndicator(@RequestParam("paramName") String paramName,
                                             @RequestParam("username") String username)
    {
        UserModel loggedUser = userFeatures.findByUsername(username);
        UserIndicator userIndicator = DefaultUserIndicatorFactory.build(paramName);
        Map<String, String> response = new HashMap<>();

        if (!userIndicator.isValid())
        {
            response.put("error", "indicator is not implemented");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(response);
        }

        if (loggedUser == null)
        {
            response.put("error", "bad username");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body(response);
        }

        userIndicator = userFeatures.save(userIndicator);
        loggedUser.getUserIndicators().add(userIndicator);
        userFeatures.saveUser(loggedUser);

        response.put("id", userIndicator.getId());
        response.put("toString", userIndicator.stringRepresentation());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/indicators/{username}/{indicatorId}")
    public Map deleteIndicator(@PathVariable("indicatorId") String indicatorId,
                               @PathVariable("username") String username)
    {
        return userFeatures.deleteIndicator(username, indicatorId);
    }

}
