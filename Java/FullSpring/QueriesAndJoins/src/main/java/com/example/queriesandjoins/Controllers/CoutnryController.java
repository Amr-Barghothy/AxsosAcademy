package com.example.queriesandjoins.Controllers;

import com.example.queriesandjoins.Models.Country;
import com.example.queriesandjoins.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CoutnryController {

    @Autowired
    CountryService countryService;

    @RequestMapping("/")
    public String index() {
        List<Country> countries = countryService.getAllCountries();
        for (Country country : countries) {
            System.out.println(country.getCities().stream().count());
//            for (Language lang : country.getLanguages()) {
//                if (lang.getLanguage().equalsIgnoreCase("Slovene")) {
//                    System.out.println(country.getName() + " -> " + lang.getPercentage());
//                }
//            }
        }
        return "s";
    }
}
