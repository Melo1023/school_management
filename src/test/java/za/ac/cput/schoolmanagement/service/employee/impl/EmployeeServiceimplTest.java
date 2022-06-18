package za.ac.cput.schoolmanagement.service.employee.impl;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeServiceImpl Test.
    Date: 17 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.lookup.Name;
import za.ac.cput.schoolmanagement.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceimplTest {

    private final Name user = new Name.Builder()
            .setFirstName("Mike")
            .setLastName("Long")
            .build();

    private final Employee employee = new Employee.Builder()
            .setStaffId("001")
            .setEmail("mike@gmail.com")
            .setName(user)
            .build();
    @Autowired
    private EmployeeService service;

    @BeforeEach
    void setUp() {
    }


    @Test
    void save() {
        Employee saved = service.save(employee);
        String emp1 = String.valueOf(employee);
        String output = String.valueOf(saved);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(emp1, output)
        );
        System.out.println(saved);
    }

    @Test
    void tearDown() {

        service.delete(employee);
    }

    @Test
    void read() {
        Employee saved = service.save(employee);
        Optional<Employee> read = service.read(saved.getStaffId());
        System.out.println(read);
        String emp1 = String.valueOf(saved);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(emp1, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(employee);
    }

    @Test
    void findByStaffId() {
        Employee saved = service.save(employee);
        String employeeId = saved.getStaffId();
        List<Employee> employeeNameList = service.getAll(employeeId);
        System.out.println(employeeNameList);
        assertSame(1, employeeNameList.size());
    }

    @Test
    void getEmployeeNameFromEmail() {
        Employee saved = service.save(employee);
        if (service.valEmail(employee.getEmail()) == false) {
            System.out.println("Please input valid email.");
        } else {
            System.out.println(saved);
        }
    }
}