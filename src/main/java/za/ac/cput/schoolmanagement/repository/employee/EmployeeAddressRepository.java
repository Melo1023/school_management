package za.ac.cput.schoolmanagement.repository.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeAddressRepository.
    Date: 11 June 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;

import java.util.List;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

    List<EmployeeAddress> getAll(String staffId);
}
