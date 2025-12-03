package com.example.queriesandjoins.Repositories;

import com.example.queriesandjoins.Models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

}