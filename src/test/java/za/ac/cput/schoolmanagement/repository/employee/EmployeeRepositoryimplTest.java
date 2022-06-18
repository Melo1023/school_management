package za.ac.cput.schoolmanagement.repository.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeRepository Test.
    Date: 17 June 2022
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.employee.EmployeeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryimplTest {

    private final Name user = new Name.Builder()
            .setFirstName("Mike")
            .setLastName("Long")
            .build();
    private final Employee employee = new Employee.Builder()
            .setStaffId("001")
            .setEmail("mike@gmail.com")
            .setName(user)
            .build();
    @Autowired private EmployeeRepository repository;

    @AfterEach
    void tearDown() {
        repository.delete(employee);
    }

    @Test
    void save() {
        Employee saved = repository.save(employee);
        String emp1 = String.valueOf(employee);
        String output = String.valueOf(saved);
        assertNotNull(saved);
        assertSame(emp1, output);
    }

    @Test
    void read() {
        Employee saved = repository.save(employee);
        Optional<Employee> read = repository.findById(saved.getStaffId());
        String emp1 = String.valueOf(saved);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(emp1, output)
        );
    }

    @Test
    void delete() {
        Employee saved = repository.save(employee);
        List<Employee> getAll = repository.findAll();
        repository.delete(saved);
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(employee);
        List<Employee> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }
}