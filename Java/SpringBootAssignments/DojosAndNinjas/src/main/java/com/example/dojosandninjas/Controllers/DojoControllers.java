package com.example.dojosandninjas.Controllers;

import com.example.dojosandninjas.Models.Dojo;
import com.example.dojosandninjas.Services.DojoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoControllers {
    @Autowired
    DojoService dojoService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/dojo/new";
    }

    @RequestMapping("/dojo/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo, Model mode) {
        return "newDojo";
    }

    @PostMapping("/createDojo")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newDojo";
        }else {
            dojoService.createDojo(dojo);
            return "redirect:/dojo/new";
        }
    }

    @RequestMapping("/dojos/{id}")
    public String showDojo(@PathVariable Long id, Model model) {
        model.addAttribute("dojo",dojoService.getDojoById(id));
        return "showDojo";
    }
}
