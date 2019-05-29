package com.es.cloudapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecoveryController {

    @GetMapping(value = "/recovery")
    public String Recovery() {
        return "recovery";
    }
    @PostMapping(value = "/recovery")
    public String postRecovery(@RequestParam String username, @RequestParam String mail) {
        System.err.println(username);
        System.out.println(mail);
        return "redirect:recovery";
    }
}
