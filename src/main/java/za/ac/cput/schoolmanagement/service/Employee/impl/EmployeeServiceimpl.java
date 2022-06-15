package za.ac.cput.schoolmanagement.service.Employee.impl;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeServiceimpl.
    Date: 11 June 2022
 */

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.Employee.EmployeeRepository;
import za.ac.cput.schoolmanagement.repository.Employee.impl.EmployeeRepositoryimpl;
import za.ac.cput.schoolmanagement.service.Employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceimpl (EmployeeRepository repository) {
        this.repository = repository;
    }
    private static EmployeeService SERVICE;
/*

    public EmployeeServiceimpl() {
        repository = EmployeeRepositoryimpl.getRepository();
    }

    public static EmployeeService getService() {
        if (SERVICE == null)
            SERVICE = new EmployeeServiceimpl();
        return SERVICE;
    }
 */

    public Employee save (Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> read (String staffId) {
        return  repository.findById(staffId);
    }

    public void delete (Employee employee) {
        repository.delete(employee);
    }

    public List<Employee> getAll() {
        return repository.getAll();
    }

    public void deleteById(String staffId) {
        Optional<Employee> employee = read(staffId);
        if (employee.isPresent()) delete(employee.get());
    }
}
