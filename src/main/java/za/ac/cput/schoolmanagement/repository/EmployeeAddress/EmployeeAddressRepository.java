package za.ac.cput.schoolmanagement.repository.EmployeeAddress;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.IRepository;

import java.util.List;

public interface EmployeeAddressRepository extends IRepository<EmployeeAddress, String> {

    List<EmployeeAddress> getAll(String staffId);
}
