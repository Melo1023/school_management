package za.ac.cput.schoolmanagement.controller;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeController Test.
    Date: 17 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.service.employee.EmployeeService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class EmployeeControllerTest {

    @LocalServerPort private int port;
    @Autowired private TestRestTemplate restTemplate;
    @Autowired private EmployeeController controller;
    @Autowired private EmployeeService service;

    private Name user;
    private Employee employee;
    private String baseUrl;

    @BeforeEach
    void setUp() {
        user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        employee = new Employee.Builder().setStaffId("001").setEmail("test@email.com").setName(user).build();
        this.baseUrl = "http://localhost:" + this.port + "school/employee/";
    }

    @Test
    void save() {
        String url = baseUrl + "save/";
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate
                .postForEntity(url, this.employee, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void read() {
        String url = baseUrl + "read/" + this.employee.getStaffId();
        System.out.println(url);
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);
        System.out.println(response);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test
    void delete() {
        String url = baseUrl + "delete/" + this.employee.getStaffId();
        this.restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "all/";
        System.out.println(url);
        ResponseEntity<Employee[]> response =
                this.restTemplate.getForEntity(url, Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 1)
        );
    }

    @Test
    void findByEmail() {
        String url = baseUrl + "get-by-email/" + this.employee.getEmail();
        System.out.println(url);
        ResponseEntity<Employee> saved = controller.save(employee);

        if (!service.valEmail(employee.getEmail())) {
            System.out.println("Please enter valid email.");
        } else {
            System.out.println("Email is valid...");
            System.out.println("Email belongs to: " + saved);
        }
        assertAll(
                () -> assertEquals(HttpStatus.OK, saved.getStatusCode()),
                () -> assertNotNull(saved.getBody())
        );
    }
}