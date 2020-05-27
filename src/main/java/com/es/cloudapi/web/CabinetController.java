package com.es.cloudapi.web;

import com.es.cloudapi.entity.Response;
import com.es.cloudapi.service.ResponseService;
import com.es.cloudapi.service.security.SecurityPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;

@Controller
public class CabinetController {

    @Autowired
    private ResponseService responseService;

    @GetMapping(value = "/cabinet")
    public String list(ModelMap map, Authentication authentication) {
        map.put("items", responseService.findAllByPerson(((SecurityPerson) authentication.getPrincipal()).getId()));
        return "cabinet";
    }

    @GetMapping(value = "/cabinet/add")
    public String addGet(ModelMap map, Authentication authentication) {
        map.put("active", true);
        return "request";
    }

    @PostMapping(value = "/cabinet/add")
    public String addPost(Authentication authentication,
                          RedirectAttributes redirectAttributes,
                          @RequestParam(required = false) boolean active,
                          @RequestParam(required = false) String type,
                          @RequestParam(required = false) String url,
                          @RequestParam(required = false) int code,
                          @RequestParam(required = false) String body
    ) {
        responseService.update(null, ((SecurityPerson) authentication.getPrincipal()).getId(), active, type, url, code, body);
        redirectAttributes.addFlashAttribute("messages", Collections.singletonList("Данные успешно сохранены"));
        return "redirect:/cabinet";
    }

    @GetMapping(value = "/cabinet/{id}")
    public String editGet(@PathVariable Integer id, ModelMap map, Authentication authentication) {
        Response item = responseService.findOneByIdAndPerson(id, ((SecurityPerson) authentication.getPrincipal()).getId());
        map.put("item", item);
        map.put("active", item.isActive());
        map.put("type", item.getType());
        map.put("url", item.getUrl());
        map.put("code", item.getCode());
        map.put("body", item.getBody());
        return "request";
    }

    @PostMapping(value = "/cabinet/{id}")
    public String editPost(@PathVariable Integer id,
                           Authentication authentication,
                           RedirectAttributes redirectAttributes,
                           @RequestParam(required = false) String action,
                           @RequestParam(required = false) boolean active,
                           @RequestParam(required = false) String type,
                           @RequestParam(required = false) String url,
                           @RequestParam(required = false) int code,
                           @RequestParam(required = false) String body) {
        if("delete".equals(action)) {
            responseService.delete(id, ((SecurityPerson) authentication.getPrincipal()).getId());
            redirectAttributes.addFlashAttribute("messages", Collections.singletonList("Запрос удален"));
        } else {
            responseService.update(id, ((SecurityPerson) authentication.getPrincipal()).getId(), active, type, url, code, body);
            redirectAttributes.addFlashAttribute("messages", Collections.singletonList("Данные успешно сохранены"));
        }
        return "redirect:/cabinet";
    }

    @DeleteMapping(value = "/cabinet/{id}")
    public String delete(@PathVariable Integer id, Authentication authentication, RedirectAttributes redirectAttributes) {
        responseService.delete(id, ((SecurityPerson) authentication.getPrincipal()).getId());
        redirectAttributes.addFlashAttribute("messages", Collections.singletonList("Запрос удален"));
        return "redirect:/cabinet";
    }

}
