package za.ac.cput.schoolmanagement.service.EmployeeAddress;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface EmployeeAddressService extends IService<EmployeeAddress, String> {

    List<EmployeeAddress> getAll(String staffId);
}
