package com.es.cloudapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public String getLogin() {
        return "login";
    }
    @PostMapping(value = "/login")
        public String postLogin(@RequestParam String username, @RequestParam String password) {
        System.err.println(username);
        System.out.println(password);
        return "redirect:login";
        }
}
