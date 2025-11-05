package com.example.pathvariables.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariablesController {

    @RequestMapping("/daikichi/travel/{city_name}")
    public String daikichi(@PathVariable("city_name")  String city_name) {
        return "Congratulations! You will soon travel to " +city_name + "!";
    }

    @GetMapping("/daikichi/lotto/{num}")
    public String lotto(@PathVariable("num")  Integer num) {
        if (num % 2 == 0) {
            return "You will take a grand journey in the near future but be wary of tempting offers.";
        } else {
            return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
        }
    }
}
