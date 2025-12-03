package com.example.queriesandjoins.Services;

import com.example.queriesandjoins.Models.Country;
import com.example.queriesandjoins.Repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findByLanguages_LanguageContainsIgnoreCaseOrderByLanguages_PercentageDesc("Slovene");
    }

    public List<Country> getCountriesByLanguage(String language) {
        return countryRepository.findByLanguages_LanguageContainsIgnoreCaseOrderByLanguages_PercentageDesc(language);
    }

    public List<Country> findAll(String countryCode) {
        return countryRepository.findAll();
    }

    public Long count(Country country) {
        return countryRepository.countByCities_Country(country);
    }
}
