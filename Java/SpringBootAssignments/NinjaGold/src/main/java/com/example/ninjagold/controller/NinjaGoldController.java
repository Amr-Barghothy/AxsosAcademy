package com.example.ninjagold.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class NinjaGoldController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/process_money")
    public String processMoney(@RequestParam(value = "farm", required = false) String farm,
                               @RequestParam(value = "cave", required = false) String cave,
                               @RequestParam(value = "house", required = false) String house,
                               @RequestParam(value = "quest", required = false) String quest,
                               HttpSession session) {

        Date date = new Date();


        @SuppressWarnings("unchecked")
        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");

        if (activities == null) {
            activities = new ArrayList<>();
            session.setAttribute("activities", activities);
        }

        if (farm != null) {
            Random random = new Random();
            int min = 10;
            int max = 20;
            int randomNumber = random.nextInt(max - min + 1) + min;
            activities.add("You entered a farm and earned " + randomNumber + " gold. " + date);
        }

        if (cave != null) {
            Random random = new Random();
            int min = 5;
            int max = 10;
            int randomNumber = random.nextInt(max - min + 1) + min;
            activities.add("You entered a cave and earned " + randomNumber + " gold. " + date);
        }

        if (house != null) {
            Random random = new Random();
            int min = 2;
            int max = 5;
            int randomNumber = random.nextInt(max - min + 1) + min;
            activities.add("You entered a house and earned " + randomNumber + " gold. " + date);
        }

        if (quest != null) {
            Random random = new Random();
            int min = 0;
            int max = 50;
            int randomNumber = random.nextInt(max - min + 1) + min;
            int flag = random.nextInt(2);
            if (flag == 1) {
                activities.add("You completed a quest and earned " + randomNumber + " gold. " + date);
            } else {
                activities.add("You failed a quest and lost " + randomNumber + " gold. Ouch " + date);
            }
        }

        return "redirect:/";
    }
}
