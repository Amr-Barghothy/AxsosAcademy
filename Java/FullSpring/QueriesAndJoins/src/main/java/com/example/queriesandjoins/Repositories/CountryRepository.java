package com.example.queriesandjoins.Repositories;

import com.example.queriesandjoins.Models.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findAll();

    List<Country> findByLanguages_LanguageContainsIgnoreCaseOrderByLanguages_PercentageDesc(String language);

    long countByCities_Country(Country country);


}