package za.ac.cput.schoolmanagement.repository.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.IRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> getAll();
}
