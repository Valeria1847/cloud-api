/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2020
 */

package com.es.cloudapi.web;

import com.es.cloudapi.service.security.PersonService;
import com.es.cloudapi.service.security.SecurityPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collections;

@Controller
public class SettingsController {

    private PersonService personService;

    @GetMapping(value = "/settings")
    public String get(ModelMap map, Authentication authentication) {
        map.put("person", personService.findById(((SecurityPerson)authentication.getPrincipal()).getId()));
        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public String save(
        @RequestParam String name, @RequestParam String surname, @RequestParam String login,
        @RequestParam String email, @RequestParam String password, @RequestParam String password2,
        Authentication authentication,
        RedirectAttributes redirectAttributes
    ) {
        try {
            personService.save((SecurityPerson) authentication.getPrincipal(), name, surname, login, email, password, password2);
            redirectAttributes.addFlashAttribute("messages", Collections.singletonList("Данные успешно сохранены"));
        } catch (Throwable th) {
            redirectAttributes.addFlashAttribute("errors", Collections.singletonList("Ошибка при сохранении данных: " + th.getMessage()));
        }
        return "redirect:/settings";
    }


    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
