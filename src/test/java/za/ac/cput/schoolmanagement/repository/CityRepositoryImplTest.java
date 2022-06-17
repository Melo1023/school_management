/*
CityRepositoryImplTest.java
This is the City Repository Impl Test class
Author: Felecia Zweni
Date: 17/06/2022
 */


package za.ac.cput.schoolmanagement.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.City;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CityRepositoryImplTest {
    private final City city = new City.Builder()
            .setName("Stellenbosch")
            .setId("7600")
            .build();
    @Autowired
    private CityRepository repository;

    @AfterEach
    void tearDown() {
        repository.delete(city);
    }

    @Test
    void save() {
        City saved = repository.save(city);
        assertNotNull(saved);
        assertSame(city, saved);
    }

    @Test
    void read() {
        City saved = repository.save(city);
        Optional<City> read = repository.findById(saved.getName());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        City saved = repository.save(city);
        List<City> getAll = repository.findAll();
        repository.delete(saved);
        getAll = repository.findAll();
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(city);
        List<City> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }

}
