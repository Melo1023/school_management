package za.ac.cput.schoolmanagement.service.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Interface for the Employee service.
    Date: 11 June 2022
 */

import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee, String> {

    List<Employee> getAll(String staffId);
    void deleteById(String staffId);

    boolean valEmail (String input);
}
