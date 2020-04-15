package com.es.cloudapi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CabinetController {

    @GetMapping(value = "/cabinet")
    public String getLogin() {
        return "cabinet";
    }

}
