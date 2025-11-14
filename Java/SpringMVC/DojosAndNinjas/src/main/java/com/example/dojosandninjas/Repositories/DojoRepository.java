package com.example.dojosandninjas.Repositories;

import com.example.dojosandninjas.Models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
