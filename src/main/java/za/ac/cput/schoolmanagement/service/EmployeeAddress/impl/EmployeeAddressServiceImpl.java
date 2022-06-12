package za.ac.cput.schoolmanagement.service.EmployeeAddress.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddress.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.repository.EmployeeAddress.impl.EmployeeAddressRepositoryimpl;
import za.ac.cput.schoolmanagement.service.EmployeeAddress.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    private final EmployeeAddressRepository repository;
    private static  EmployeeAddressService SERVICE;

    public EmployeeAddressServiceImpl (EmployeeAddressRepository repository) {
        this.repository = repository;
    }

    public EmployeeAddressServiceImpl() {
        repository = EmployeeAddressRepositoryimpl.getRepository();
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
        return repository.read(staffId);
    }

    public void delete (EmployeeAddress employeeAddress) {
        repository.delete(employeeAddress);
    }

    public List<EmployeeAddress> getAll(String staffId) {
        return repository.getAll(staffId);
    }
}
