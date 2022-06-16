package za.ac.cput.schoolmanagement.repository.employee;

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
        assertNotNull(saved);
        assertSame(employee, saved);
    }

    @Test
    void read() {
        Employee saved = repository.save(employee);
        Optional<Employee> read = repository.findById(saved.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Employee saved = repository.save(employee);
        List<Employee> getAll = repository.findAll();
        repository.delete(saved);
        getAll = repository.findAll();
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(employee);
        List<Employee> getAll = repository.findAll();
        assertEquals(1, getAll.size());
    }
}