package za.ac.cput.schoolmanagement.repository.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.repository.Employee.impl.EmployeeRepositoryimpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryimplTest {

    private Employee employee;
    private Name user;
    private EmployeeRepositoryimpl repository;

    @BeforeEach
    void setUp() {
        user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        employee = EmployeeFactory.createEmployeeFactory("001","mike@school.co.za", user);
        repository = EmployeeRepositoryimpl.getRepository();
        Employee saved = repository.save(employee);
        assertSame(employee, saved);
    }

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
        Optional<Employee> read = repository.read(saved.getStaffId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Employee saved = repository.save(employee);
        List<Employee> getAll = repository.getAll(employee.getStaffId());
        repository.delete(saved);
        getAll = repository.getAll(employee.getStaffId());
        assertEquals(0, getAll.size());
    }

    @Test
    void getAll() {
        repository.save(employee);
        List<Employee> getAll = repository.getAll(employee.getStaffId());
        assertEquals(1, getAll.size());
    }
}