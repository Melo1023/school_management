/*
CityServiceImpl.java
This is the City
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.service.City.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.CityRepository;
import za.ac.cput.schoolmanagement.service.City.CityService;

import java.util.List;
import java.util.Optional;


public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Autowired
    public CityServiceImpl(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public City save(City city) {
        return this.repository.save(city);
    }

    @Override
    public Optional<City> read(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(City city) {
        this.repository.delete(city);

    }

    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(String id) {
        Optional<City> city = read(id);
        if(city.isPresent()) delete(city.get());

    }

    @Override
    public List<City> getAll(String cityId) {
        return repository.findAll();
    }

    @Override
    public void deleteById(String id) {
        Optional<City> city = read(id);
        if (city.isPresent()) delete(city.get());
    }


}
