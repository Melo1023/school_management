package za.ac.cput.schoolmanagement.service.employee.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.employee.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.employee.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.service.employee.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private EmployeeAddressRepository repository;
    private static  EmployeeAddressService SERVICE;

    public EmployeeAddressServiceImpl (EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    public EmployeeAddressServiceImpl() {
    }

    public static EmployeeAddressService getService() {
        if (SERVICE == null)
            SERVICE = new EmployeeAddressServiceImpl();
        return SERVICE;
    }

    public EmployeeAddress save (EmployeeAddress employeeAddress) {
        return repository.save(employeeAddress);
    }

    public Optional<EmployeeAddress> read (String staffId) {
        return repository.findById(staffId);
    }

    public void delete (EmployeeAddress employeeAddress) {
        repository.delete(employeeAddress);
    }

    public List<EmployeeAddress> getAll(String staffId) {
        return repository.findAll();
    }
}
