package com.example.burgertrackerii.Services;

import com.example.burgertrackerii.Models.Burger;
import com.example.burgertrackerii.Repositories.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerServices {
    @Autowired
    BurgerRepository burgerRepository;


    public void createBurger(Burger burger) {
        burgerRepository.save(burger);
    }

    public List<Burger> getAllBurgers() {
        return burgerRepository.findAll();
    }

    public Burger getBurgerById(Long id) {
        Optional<Burger> optional = burgerRepository.findById(id);
        Burger burger = optional.orElse(null);
        return burger;
    }

    public Burger updateBurger(Long id,Burger burger) {
        Burger existingBurger = burgerRepository.findById(id).orElse(null);

        if (existingBurger != null) {
        existingBurger.setBurgerName(burger.getBurgerName());
        existingBurger.setRestaurantName(burger.getRestaurantName());
        existingBurger.setRating(burger.getRating());
        existingBurger.setNote(burger.getNote());
        return burgerRepository.save(existingBurger);
    } else {
            return null;
        }
    }
}
