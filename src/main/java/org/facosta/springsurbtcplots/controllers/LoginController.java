package org.facosta.springsurbtcplots.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error,
                        Model model, Principal principal)
    {
        if (principal != null)
            return "redirect:/";

        model.addAttribute("error", error);
        return "login";
    }

}
