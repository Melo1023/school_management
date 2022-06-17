package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.service.employee.EmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/employee/")
@Slf4j
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired public EmployeeController (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("save")
    public ResponseEntity<Employee> save (@Valid @RequestBody Employee employee) {
        log.info("Save request: {}", employee);
        Employee save = employeeService.save(employee);
        return ResponseEntity.ok(save);
    }

    private Optional<Employee> getById(String staffId) {
        return this.employeeService.read(staffId);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<Employee> read (@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        Employee employee = getById(staffId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        this.employeeService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Employee>> getAll(String staffId) {
        List<Employee> employees = this.employeeService.getAll(staffId);
        return ResponseEntity.ok(employees);
    }

    private Optional<Employee> getByEmail(String email) {
        return this.employeeService.read(email);
    }

    @GetMapping("get-by-email/{email}")
    public ResponseEntity<Employee> findByEmail(@PathVariable String email) {
        log.info("Read request: {}", email);
        Employee employeeEmail = getByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeEmail);
    }
}
