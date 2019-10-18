package com.lama.dal.service;

import com.lama.dal.entity.Country;
import com.lama.dal.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService {
    @Autowired
    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Optional<Country> findById(String id) {
        return countryRepository.findById(id);
    }

    public Country save(Country country) {
        return (Country) countryRepository.save(country);
    }

    public void deleteById(String id) {
        countryRepository.deleteById(id);
    }
}
