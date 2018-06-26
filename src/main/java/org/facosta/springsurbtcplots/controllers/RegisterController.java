package org.facosta.springsurbtcplots.controllers;

import org.facosta.springsurbtcplots.dto.UserRegisterDto;
import org.facosta.springsurbtcplots.services.Interfaces.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegisterController
{
    private UserRegistrationService registrationService;

    @Autowired
    public RegisterController(UserRegistrationService registrationService)
    {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String getRegisterView(Model model)
    {
        UserRegisterDto dto = new UserRegisterDto();
        model.addAttribute("user", dto);
        return "register";
    }

    @PostMapping("/register")
    public String postRegisterView(@ModelAttribute("user") @Valid UserRegisterDto dto,
                                   BindingResult bindingResult,
                                   Model model)
    {
        boolean success;
        if (!bindingResult.hasErrors())
        {
            success = registrationService.registerNewUser(dto);
            if (!success)
                bindingResult.rejectValue("username",
                                          "username.exists",
                                          "Username already exists");
        }
        if (bindingResult.hasErrors())
        {
            List<ObjectError> globalErrors = bindingResult.getGlobalErrors();

            // add the binding error as a model attribute to make it easier to access
            // in the template
            if(globalErrors.size() > 0)
                model.addAttribute("passwordMatchError",
                                   globalErrors.get(0).getDefaultMessage());

            model.addAttribute("user", dto);
            return "register";
        }

        return "redirect:/";
    }
}
