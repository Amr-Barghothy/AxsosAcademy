package com.example.burgertrackerii.Controllers;

import com.example.burgertrackerii.Models.Burger;
import com.example.burgertrackerii.Services.BurgerServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BurgerController {
    @Autowired
    BurgerServices burgerServices;

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("burger") Burger burger) {
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

    @RequestMapping("/edit/{id}")
    public String editBurger(@PathVariable Long id, Model model) {
        Burger burger = burgerServices.getBurgerById(id);
        model.addAttribute("burger", burger);
        return "edit";
    }

    @PutMapping("/edit/{id}")
    public String updateBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, @PathVariable Long id, Model model) {
        System.out.println("Im Here");
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            System.out.println(id);
            return "edit";
        } else {
            burgerServices.updateBurger(id, burger);
            return "redirect:/";
        }
    }
}
