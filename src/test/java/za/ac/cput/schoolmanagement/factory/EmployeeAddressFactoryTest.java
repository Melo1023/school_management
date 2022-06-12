package za.ac.cput.schoolmanagement.factory;

/*
    Student: Ian Louw
    Student Number: 216250773
    Test class for EmployeeAddressFactory.
    Date: 11 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {

    private EmployeeAddress employeeAddress;
    private EmployeeAddress employeeAddress1;

    @BeforeEach
    void setUp() {
        Address location = new Address.Builder().setStreetNumber("11").setStreetName("Round street").build();
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("001", location);
        employeeAddress1 = employeeAddress;
    }

    @Test
    void buildWithSuccess() {
        Address location = new Address.Builder().setUnitNumber("11").setStreetNumber("11").setStreetName("Round street").build();
        EmployeeAddress employeeAddress = EmployeeAddressFactory.createEmployeeAddress("001", location);

        System.out.println(employeeAddress);
        assertNotNull(employeeAddress);
    }

    @Test
    void buildWithError() {
        Address location = new Address.Builder().setStreetNumber("11").setStreetName("Round street").build();

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeAddressFactory.createEmployeeAddress("001", null));

        String exceptionMessage = exception.getMessage();

    }

    @Test
    void buildWithIdenticalValue() {
        assertSame(employeeAddress, employeeAddress1);
        System.out.println("Values are identical");
    }

    @Test
    @Timeout(2)
    void buildWithTimeout() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("Test timed out.... Please be patient test will pass soon...!");
    }

    @Test
    @Disabled
    void buildIsDisabled(){
        assertEquals(employeeAddress,employeeAddress1);
        System.out.println("Test has been disabled...");
    }

}