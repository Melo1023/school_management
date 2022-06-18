package za.ac.cput.schoolmanagement.service.employee.impl;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeAddressServiceImpl Test.
    Date: 17 June 2022
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.employee.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeAddressServiceImplTest {

    private final Address location = new Address.Builder()
            .setStreetName("Round Street")
            .setStreetNumber("15")
            .setPostalCode(7400)
            .build();
    private final EmployeeAddress employeeAddress = new EmployeeAddress.Builder()
            .setStaffId("001")
            .setAddress(location)
            .build();
    @Autowired
    private EmployeeAddressService service;

    @Test
    void save() {
        EmployeeAddress saved = service.save(employeeAddress);
        String empAdd1 = String.valueOf(employeeAddress);
        String output = String.valueOf(saved);
        assertAll(
                ()-> assertNotNull(saved),
                () -> assertEquals(empAdd1, output)
        );
        System.out.println(saved);
    }

    @Test
    void read() {
        EmployeeAddress saved = service.save(employeeAddress);
        Optional<EmployeeAddress> read = service.read(saved.getStaffId());
        System.out.println(read);
        String empAdd1 = String.valueOf(saved);
        String output = String.valueOf(read.get());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(empAdd1, output)
        );
    }

    @Test
    void delete() {
        this.service.delete(employeeAddress);
    }

    @Test
    void getAll() {
        EmployeeAddress saved = service.save(employeeAddress);
        String staffId = saved.getStaffId();
        List<EmployeeAddress> employeeAddressList = service.getAll(staffId);
        System.out.println(employeeAddressList);
        assertSame(1, employeeAddressList.size());
    }

}