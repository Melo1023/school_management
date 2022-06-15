/*
CityRepositoryImpl.java
This is the City
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.repository.City.impl;


import za.ac.cput.schoolmanagement.domain.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityRepositoryImpl {
    private static CityRepositoryImpl repository = null;
    private List<City> cityDB;

    private CityRepositoryImpl() {
        cityDB = new ArrayList<>();
    }

    public City save (City city) {
        Optional<City> read = read(city.getId());
        if (read.isPresent()) {
            delete(read.get());
        }
        cityDB.add(city);
        return city;
    }

    public Optional<City> read (String id) {
        return cityDB.stream().
                filter(e -> e.getId() == id).
                findAny();
    }

    public void delete (City city) {
        cityDB.remove(city);
    }

    public List<City> getAll () {
        return repository.getAll();
    }
}
