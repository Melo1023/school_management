package za.ac.cput.schoolmanagement.repository.Employee;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.IRepository;

import java.util.List;

public interface EmployeeRepository extends IRepository<Employee, String> {

    List<Employee> getAll(String staffId);
}
