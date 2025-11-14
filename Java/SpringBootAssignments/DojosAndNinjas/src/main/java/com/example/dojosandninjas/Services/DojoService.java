package com.example.dojosandninjas.Services;

import com.example.dojosandninjas.Models.Dojo;
import com.example.dojosandninjas.Repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {
    @Autowired
    DojoRepository dojoRepository;

    public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo getDojoById(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }
}
