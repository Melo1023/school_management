package za.ac.cput.schoolmanagement.service.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeAddressService.
    Date: 17 June 2022
 */

import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String> {

    List<EmployeeAddress> getAll(String staffId);
    void deleteById(String staffId);
}
