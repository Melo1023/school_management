package za.ac.cput.schoolmanagement.service.Employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Interface for the Employee service.
    Date: 11 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface EmployeeService extends IService<Employee, String> {

    List<Employee> getAll();
    void deleteById(String staffId);
}
