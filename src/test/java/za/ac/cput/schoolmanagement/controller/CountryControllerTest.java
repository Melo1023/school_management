package za.ac.cput.schoolmanagement.controller;

/*
 @Author: Lihle Njobe
 Student number : 218193882
 Country controller Test cases
 Due date: 18 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.lookup.Country;
import za.ac.cput.schoolmanagement.factory.lookup.CountryFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CountryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired private CountryController controller;
    @Autowired private TestRestTemplate restTemplate;

    private Country country;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        country = new Country.Builder().setId("Id27").setName("South Africa").build();
        this.baseUrl = "http://localhost:" + this.port + "/school/country/";

    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate
                .postForEntity(url, this.country, Country.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.country.getId();
        System.out.println(url);
        ResponseEntity<Country> response = this.restTemplate.getForEntity(url,Country.class);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode())
        );

    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.country.getId();
        System.out.println(url);
       this.restTemplate.delete(url,Country.class);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/" + this.country.getId();
        System.out.println(url);
        ResponseEntity<Country[]> response = this.restTemplate.getForEntity(url, Country[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}