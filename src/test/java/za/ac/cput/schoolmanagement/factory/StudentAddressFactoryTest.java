/*
    StudentAddressFactoryTest.java
    FactoryTest for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */


package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public  class StudentAddressFactoryTest {

    public static final String BASE_URL = "http://localhost:8080/SchoolManagement/StudentAddress";

    @Autowired

    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin","admin")
                .getForEntity(BASE_URL + "/getall", String.class);
        System.out.println(result.getStatusCode());
    }
    @Test
    public void createStudentAddress() {
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(BASE_URL + "/create/StudentAddress", null, String.class);
        System.out.println(result.getStatusCode());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}