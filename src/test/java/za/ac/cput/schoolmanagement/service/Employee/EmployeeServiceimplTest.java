package za.ac.cput.schoolmanagement.service.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.repository.Employee.impl.EmployeeRepositoryimpl;
import za.ac.cput.schoolmanagement.service.Employee.EmployeeService;
import za.ac.cput.schoolmanagement.service.Employee.impl.EmployeeServiceimpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceimplTest {

    private Employee employee;
    private Name user;
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        employee = EmployeeFactory.createEmployeeFactory("001", "Mike@school.co.za", user);
        service = EmployeeServiceimpl.getService();
        Employee saved = service.save(employee);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(employee, saved)
        );
    }

    @AfterEach
    void tearDown() {
        service.delete(employee);
    }

    @Test
    void read() {
        Employee saved = service.save(employee);
        Optional<Employee> read = service.read(saved.getStaffId());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(employee, read.get())
        );
    }

    @Test
    void findByStaffId() {
        Employee saved = service.save(employee);
        String employeeId = saved.getStaffId();
        List<Employee> employeeNameList = service.getAll(employee.getStaffId());
        System.out.println(employeeNameList);
        assertSame(1, employeeNameList.size());
    }

}