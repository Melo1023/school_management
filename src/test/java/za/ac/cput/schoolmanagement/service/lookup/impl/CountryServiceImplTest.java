package za.ac.cput.schoolmanagement.service.lookup.impl;

/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country service test case
 Due date: 18 June 2022
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.domain.lookup.Country;
import za.ac.cput.schoolmanagement.service.lookup.CountryService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CountryServiceImplTest {

    private final City user = new City.Builder()
            .setId("27")
            .setName("Stellenbosch")
            .build();

    private final Country country = new Country.Builder()
            .setId("C27")
            .setName("South Africa")
            .build();

    @Autowired
    private CountryService service;

    @BeforeEach
    void setUp() {
    }


    @Test
    void save() {
        Country saved = service.save(country);
        assertNotNull(saved);
        System.out.println(saved);
    }
    @Test
    void tearDown() {

        service.delete(country);
    }

    @Test
    void read() {
        Country saved = service.save(country);
        Optional<Country> read = service.read(saved.getId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(country, read.get())
        );
    }

    @Test
    void delete() {

    }

    @Test
    void findByCountryId() {
        Country saved = service.save(country);
        String countryId = saved.getId();
        List<Country> countryNameList = service.getAll(countryId);
        System.out.println(countryNameList);
        assertSame(1, countryNameList.size());
    }

}



