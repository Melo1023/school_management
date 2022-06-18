/*
CityServiceImplTest.java
This is the city service impl test class
Author: Felecia Zweni
Date: 17/06/2022
 */

package za.ac.cput.schoolmanagement.service.lookup.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.service.lookup.CityService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CityServiceImplTest {

    private final City city = new City.Builder()
            .setId("7601")
            .setName("Stellenbosch")
            .build();


    @Autowired
    private CityService service;

    @BeforeEach
    void setUp() {
    }


    @Test
    void save() {
        City saved = service.save(city);
        assertNotNull(saved);
        System.out.println(saved);
    }
    @Test
    void tearDown() {

        service.delete(city);
    }

    @Test
    void read() {
        City saved = service.save(city);
        Optional<City> read = service.read(saved.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(city, read.get())
        );
    }

    @Test
    void delete() {

    }

    @Test
    void findByCityId() {
        City saved = service.save(city);
        String cityId = saved.getId();
        List<City> cityNameList = service.getAll(cityId);
        System.out.println(cityNameList);
        assertSame(1, cityNameList.size());
    }

}
