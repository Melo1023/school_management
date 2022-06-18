package za.ac.cput.schoolmanagement.service.lookup.impl;
/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country Repository implementation class
 Due date: 18 June 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.lookup.Country;
import za.ac.cput.schoolmanagement.repository.lookup.CountryRepository;
import za.ac.cput.schoolmanagement.service.lookup.CountryService;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryServiceImpl(CountryRepository repository) {

        this.repository = repository;
    }

    @Override
    public Country save(Country country) {

        return this.repository.save(country);
    }

    @Override
    public Optional<Country> read(String id) {

        return repository.findById(id);
    }

    @Override
    public void delete(Country country) {
        this.repository.delete(country);

    }

    @Override
    public List<Country> getAll(String id) {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<Country> country = read(id);
        if(country.isPresent()) delete(country.get());

    }
}
