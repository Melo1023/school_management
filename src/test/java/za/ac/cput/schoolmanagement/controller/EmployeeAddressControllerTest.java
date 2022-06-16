package za.ac.cput.schoolmanagement.controller;

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
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeAddressControllerTest {

    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private EmployeeAddressController controller;

    private Address location;
    private EmployeeAddress employeeAddress;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        location = new Address.Builder().setStreetNumber("15").setStreetName("Round Street").setPostalCode(7400).build();
        employeeAddress = new EmployeeAddress.Builder().setStaffId("001").setAddress(location).build();
        this.baseUrl = "http://localhost:" + this.port + "school/employee-address/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate
                .postForEntity(url, this.employeeAddress, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response = this.restTemplate
                .getForEntity(url, EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employeeAddress.getStaffId();
        this.restTemplate.delete(url);
    }

    @Test
    void getALl() {
        String url = baseUrl + "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response = this.restTemplate
                .getForEntity(url, EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }
}