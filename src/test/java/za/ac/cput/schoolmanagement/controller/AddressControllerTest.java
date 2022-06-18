package za.ac.cput.schoolmanagement.controller;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Class for AddressFactory .
    Date: 9 June 2022
 */


import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.lookup.City;
//import za.ac.cput.schoolmanagement.domain.lookup.Address;
import za.ac.cput.schoolmanagement.service.lookup.AddressService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {


    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private AddressController controller;
    @Autowired
    private AddressService service;


    private Address address;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        City city = new City.Builder().setId("2020").setName("cape town").build();

    }
}