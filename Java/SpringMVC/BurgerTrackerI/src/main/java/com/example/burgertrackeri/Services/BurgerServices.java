package com.example.burgertrackeri.Services;

import com.example.burgertrackeri.Models.Burger;
import com.example.burgertrackeri.Repositories.BurgerRepository;
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
}
