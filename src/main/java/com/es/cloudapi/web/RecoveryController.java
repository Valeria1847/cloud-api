package com.es.cloudapi.web;

import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.service.security.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecoveryController {

    @Autowired
    private PersonService personService;


    @GetMapping(value = "/recovery")
    public String Recovery() {
        return "recovery";
    }

    @PostMapping(value = "/recovery")
    public String postRecovery(@RequestParam String username, @RequestParam String email) {
        System.err.println(username);
        System.out.println(email);

        personService.recovery(username, email);
        return "redirect:recovery";
    }
}
