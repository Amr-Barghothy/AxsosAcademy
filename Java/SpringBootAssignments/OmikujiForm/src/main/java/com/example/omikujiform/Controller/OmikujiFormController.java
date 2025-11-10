package com.example.omikujiform.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiFormController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/handle_show")
    public String handleShow(@RequestParam(value = "number") String number, @RequestParam(value = "name") String name,
                             @RequestParam(value = "personName") String personName, @RequestParam(value = "prof") String prof, @RequestParam(value = "living") String living, @RequestParam(value = "nice") String nice, HttpSession session)  {

        session.setAttribute("number", number);
        session.setAttribute("name", name);
        session.setAttribute("personName", personName);
        session.setAttribute("prof", prof);
        session.setAttribute("living", living);
        session.setAttribute("nice", nice);
        return "redirect:/show";
    }

    @RequestMapping("/show")
    public String show() {
        return "show";
    }
}
