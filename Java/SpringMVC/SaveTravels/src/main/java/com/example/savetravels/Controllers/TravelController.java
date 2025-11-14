package com.example.savetravels.Controllers;

import com.example.savetravels.Models.Travel;
import com.example.savetravels.Services.TravelServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TravelController {
    @Autowired
    TravelServices travelServices;

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute("travel") Travel travel) {
        List<Travel> travels = travelServices.getAllTravels();
        model.addAttribute("travels", travels);
        return "index";
    }

    @PostMapping("/create")
    public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            travelServices.createTravel(travel);
            return "redirect:/";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editTravel(@PathVariable Long id, Model model) {
        Travel travel = travelServices.getTravelById(id);
        model.addAttribute("travel", travel);
        return "edit";
    }

    @PutMapping("update/{id}")
    public String updateTravel(@PathVariable Long id, @Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        System.out.println("Im Here");
        if (result.hasErrors()) {
            model.addAttribute("travel", travel);
            return "edit";
        } else {
            travelServices.updateTravel(id, travel);
            return "redirect:/";
        }
    }

    @DeleteMapping("/delete/travel/{id}")
    public String deleteTravel(@PathVariable Long id) {
        travelServices.deleteTravel(id);
        return "redirect:/";
    }

    @GetMapping("/expenses/{id}")
    public String expenses(@PathVariable Long id, Model model) {
        Travel travel = travelServices.getTravelById(id);
        model.addAttribute("travel", travel);
        return "details";
    }
}
