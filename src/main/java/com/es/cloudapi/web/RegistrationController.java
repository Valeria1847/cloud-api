package com.es.cloudapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping(value = "/registration")
    public String Registration() {
        return "registration";
    }
    @PostMapping(value = "/registration")
    public String postRegistration(@RequestParam String username, @RequestParam String surname, @RequestParam String login,
                                   @RequestParam String mail,@RequestParam String Password,@RequestParam String password2) {
        System.err.println(username);
        System.out.println(surname);
        System.out.println(login);
        System.out.println(mail);
        System.out.println(Password);
        System.out.println(password2);
        return "redirect:registration";
    }
}
