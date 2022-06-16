package za.ac.cput.schoolmanagement.service.employee.impl;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the EmployeeServiceimpl.
    Date: 11 June 2022
 */

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.repository.employee.EmployeeRepository;
import za.ac.cput.schoolmanagement.service.employee.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeServiceImpl() {
    }

    public Employee save (Employee employee)
    {
        return repository.save(employee);
    }

    public Optional<Employee> read (String staffId) {

        return  repository.findById(staffId);
    }

    public void delete (Employee employee) {

        repository.delete(employee);
    }

    @Override
    public List<Employee> getAll(String staffId) {

        return repository.findAll();
    }

    public void deleteById(String staffId) {
        Optional<Employee> employee = read(staffId);
        if (employee.isPresent()) delete(employee.get());
    }

    public boolean valEmail(String email) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(email);
        return matcher.find();
    }
}
