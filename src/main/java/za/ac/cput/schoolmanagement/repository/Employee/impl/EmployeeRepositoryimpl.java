package za.ac.cput.schoolmanagement.repository.Employee.impl;

import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.Employee.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepositoryimpl {

    private static EmployeeRepositoryimpl repository = null;
    private List<Employee> employeeDB;

    private EmployeeRepositoryimpl() {
        employeeDB = new ArrayList<>();
    }
/*

    public static EmployeeRepositoryimpl getRepository() {
        if (repository == null) {
            repository = new EmployeeRepositoryimpl();
        }
        return repository;
    }

 */
    public Employee save (Employee employee) {
        Optional<Employee> read = read(employee.getStaffId());
        if (read.isPresent()) {
            delete(read.get());
        }
        employeeDB.add(employee);
        return employee;
    }

    public Optional<Employee> read (String staffId) {
        return employeeDB.stream().
                        filter(e -> e.getStaffId() == staffId).
                        findAny();
    }

    public void delete (Employee employee) {
        employeeDB.remove(employee);
    }

    public List<Employee> getAll () {
        return repository.getAll();
    }
}
