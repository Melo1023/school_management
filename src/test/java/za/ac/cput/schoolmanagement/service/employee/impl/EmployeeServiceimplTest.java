package za.ac.cput.schoolmanagement.service.employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.domain.lookup.Name;

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
        assertNotNull(saved);
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
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(employee, read.get())
        );
    }

    @Test
    void delete() {

    }

    @Test
    void findByStaffId() {
        Employee saved = service.save(employee);
        String employeeId = saved.getStaffId();
        List<Employee> employeeNameList = service.getAll(employeeId);
        System.out.println(employeeNameList);
        assertSame(1, employeeNameList.size());
    }

}