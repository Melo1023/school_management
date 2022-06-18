/*
CityControllerTest.java
This is the city controller test class
Author: Felecia Zweni (218330189)
Date: 18 June 2022


 */

package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.domain.lookup.Country;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired private CityController controller;

    private Country country;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        country = new Country.Builder().setName("South Africa").setId("27").build();
        city = new City.Builder().setName("Cape Town").setId("7925").setCountry(country).build();
        this.baseUrl = "http://localhost:" + this.port + "school/city/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .postForEntity(url, this.city, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.city.getId();
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate
                .getForEntity(url, City.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.city.getId();
        this.restTemplate.delete(url);
    }

    @Test
    void getALl() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<City[]> response = this.restTemplate
                .getForEntity(url, City[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}
