package com.es.cloudapi.web;

import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping(value = "/registr")
    public String registr() {
        return "registr";
    }


    @PostMapping(value = "/registration")
    public String postRegistration(@RequestParam String username, @RequestParam String surname, @RequestParam String login,
                                   @RequestParam String mail,@RequestParam String password,@RequestParam String password2) {



        if(password == null || !password.equals(password2)) {

            return "redirect:registration";
        } else {
            personService.register(username, surname, login, mail, password);
            return "redirect:registr";
        }

    }
}
