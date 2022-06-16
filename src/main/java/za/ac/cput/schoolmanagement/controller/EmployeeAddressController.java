package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.employee.EmployeeAddressService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school/employee-address/")
@Slf4j
public class EmployeeAddressController {

    private final EmployeeAddressService employeeAddressService;

    @Autowired public EmployeeAddressController (EmployeeAddressService employeeAddressService) {
        this.employeeAddressService = employeeAddressService;
    }

    @PostMapping("save/")
    public ResponseEntity<EmployeeAddress> save (@Valid @RequestBody EmployeeAddress employeeAddress) {
        log.info("Save request: {}", employeeAddress);
        EmployeeAddress save = employeeAddressService.save(employeeAddress);
        return ResponseEntity.ok(save);
    }

    private Optional<EmployeeAddress> getById(String staffId) {
        return this.employeeAddressService.read(staffId);
    }

    @GetMapping("read/{staffId}")
    public ResponseEntity<EmployeeAddress> read (@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        EmployeeAddress employeeAddress = getById(staffId)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(employeeAddress);
    }

    @DeleteMapping("delete/")
    public ResponseEntity<Void> delete (@PathVariable String staffId) {
        log.info("Read request: {}", staffId);
        this.employeeAddressService.deleteById(staffId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all/")
    public ResponseEntity<List<EmployeeAddress>> getALl(String staffId) {
        List<EmployeeAddress> employeeAddresses = this.employeeAddressService.getAll(staffId);
        return ResponseEntity.ok(employeeAddresses);
    }
}
