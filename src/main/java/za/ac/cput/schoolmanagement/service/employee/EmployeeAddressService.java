package za.ac.cput.schoolmanagement.service.employee;

import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String> {

    List<EmployeeAddress> getAll(String staffId);
}
