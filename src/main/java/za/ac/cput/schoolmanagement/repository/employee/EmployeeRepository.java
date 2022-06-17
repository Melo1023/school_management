package za.ac.cput.schoolmanagement.repository.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeRepository.
    Date: 11 June 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    boolean valEmail (String input);
}
