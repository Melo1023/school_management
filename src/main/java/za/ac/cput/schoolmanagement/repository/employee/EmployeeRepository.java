package za.ac.cput.schoolmanagement.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
