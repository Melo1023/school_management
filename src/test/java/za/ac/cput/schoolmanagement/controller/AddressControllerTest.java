package za.ac.cput.schoolmanagement.controller;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Class for AddressFactory .
    Date: 9 June 2022
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.lookup.City;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {


    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private AddressController controller;

    private Address address;
    private City city;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        city = new City.Builder().setId("2020").setName("Cape town").build();
        address = new Address.Builder().setUnitNumber("20").setComplexName("A flats").setStreetNumber("6826").setStreetName("samora").setPostalCode(7785).setCity(city).build();

        this.baseUrl = "http://localhost:" + this.port + "school_management/address/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate
                .postForEntity(url, this.address, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.address.getStreetNumber();
        System.out.println(url);
        ResponseEntity<Address> response = this.restTemplate
                .getForEntity(url, Address.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.address.getStreetNumber();
        this.restTemplate.delete(url);
    }

    @Test
    void getALl() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<Address[]> response = this.restTemplate
                .getForEntity(url, Address[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}