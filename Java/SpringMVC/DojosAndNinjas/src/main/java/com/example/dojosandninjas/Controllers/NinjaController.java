package com.example.dojosandninjas.Controllers;

import com.example.dojosandninjas.Models.Dojo;
import com.example.dojosandninjas.Models.Ninja;
import com.example.dojosandninjas.Services.DojoService;
import com.example.dojosandninjas.Services.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaController {
    @Autowired
    DojoService dojoService;
    @Autowired
    NinjaService ninjaService;

    @GetMapping("/ninja/new")
    public String newDojo(@ModelAttribute("ninja") Ninja ninja,Model model) {
        model.addAttribute("dojos",dojoService.getAllDojos());

        return "newNinja";
    }

    @PostMapping("/createNinja")
    public String createNinja(@RequestParam("dojo") Long dojoId, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newNinja";
        }else {
            Dojo dojo = dojoService.getDojoById(dojoId);
            ninjaService.createNinja(ninja,dojo);
            return "redirect:/ninja/new";
        }
    }
}
