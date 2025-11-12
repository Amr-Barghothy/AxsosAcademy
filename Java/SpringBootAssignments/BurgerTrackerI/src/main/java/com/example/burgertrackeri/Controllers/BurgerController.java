package com.example.burgertrackeri.Controllers;

import com.example.burgertrackeri.Models.Burger;
import com.example.burgertrackeri.Services.BurgerServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BurgerController {
    @Autowired
    BurgerServices burgerServices;

    @RequestMapping("/")
    public String index(Model model,@ModelAttribute("burger") Burger burger) {
        List<Burger> burgers = burgerServices.getAllBurgers();
        model.addAttribute("burgers", burgers);
        return "index";
    }

    @PostMapping("/create")
    public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            burgerServices.createBurger(burger);
            return "redirect:/";
        }
    }
}
