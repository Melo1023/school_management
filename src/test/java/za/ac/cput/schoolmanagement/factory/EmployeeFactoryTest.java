package za.ac.cput.schoolmanagement.factory;

/*
    Student: Ian Louw
    Student Number: 216250773
    Test class for EmployeeFactory.
    Date: 11 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.factory.employee.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    private Employee employee;
    private Employee employee1;

    @BeforeEach
    void setUp() {

        Name user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        Employee employee = EmployeeFactory.createEmployeeFactory("001", "Mike@school.co.za", user);
        Employee employee1 = employee;
    }

    @Test
    void buildWithSuccess() {

        Name user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        Employee employee = EmployeeFactory.createEmployeeFactory("001", "Mike@school.co.za", user);

        System.out.println(employee);
    }

    @Test
    void buildWithError() {
        Name user = new Name.Builder().setFirstName("Mike").setLastName("Long").build();
        // Employee employee = EmployeeFactory.createEmployeeFactory(null, "Mike@school.co.za", user);

        // System.out.println(employee);

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                EmployeeFactory.createEmployeeFactory(null, "Mike@school.co.za", user));

        String exceptionMessage = exception.getMessage();
    }

    @Test
    void buildWithIdenticalValue() {
        assertSame(employee, employee1);
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
        assertEquals(employee,employee1);
        System.out.println("Test has been disabled...");
    }
}