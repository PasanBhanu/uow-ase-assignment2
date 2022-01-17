package com.iituow.groupi.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dilshanboteju
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("welcome", "Finance Application");
        return "index";
    }
}
