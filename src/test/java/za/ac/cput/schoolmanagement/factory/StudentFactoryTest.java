/*
    StudentFactoryTest.java
    FactoryTest for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class StudentFactoryTest {

    private static final String BASE_URL = "http://localhost:8080/schoolmanagement/student";

    @Autowired
    private TestRestTemplate restTemplate;



    @Test
    public void createStudent() {
        ResponseEntity result = restTemplate.withBasicAuth("admin" , "admin")
                .postForEntity(BASE_URL + "/create/student" ,null , String.class);
        System.out.println(result.getStatusCode());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(BASE_URL+"/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }
}