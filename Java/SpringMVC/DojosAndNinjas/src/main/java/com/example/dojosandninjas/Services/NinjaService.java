package com.example.dojosandninjas.Services;

import com.example.dojosandninjas.Models.Dojo;
import com.example.dojosandninjas.Models.Ninja;
import com.example.dojosandninjas.Repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    @Autowired
    NinjaRepository ninjaRepository;

    public void createNinja(Ninja ninja, Dojo dojo) {
        ninjaRepository.save(ninja);
        ninja.setDojo(dojo);
    }

    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    public Ninja getNinjaById(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }
}
