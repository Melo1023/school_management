package za.ac.cput.schoolmanagement.repository.EmployeeAddress.impl;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddress.EmployeeAddressRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeAddressRepositoryimpl implements EmployeeAddressRepository {

    private static EmployeeAddressRepositoryimpl repository = null;
    private List<EmployeeAddress> employeeAddressDB;

    private EmployeeAddressRepositoryimpl() {
        employeeAddressDB = new ArrayList<>();
    }

    public static EmployeeAddressRepositoryimpl getRepository() {
        if (repository == null) {
            repository = new EmployeeAddressRepositoryimpl();
        }
        return repository;
    }

    public EmployeeAddress save (EmployeeAddress employeeAddress) {
        Optional<EmployeeAddress> read = read(employeeAddress.getStaffId());
        if (read.isPresent()) {
            delete(read.get());
        }
        employeeAddressDB.add(employeeAddress);
        return employeeAddress;
    }

    public Optional<EmployeeAddress> read (String staffId) {
        return employeeAddressDB.stream().
                                filter(e -> e.getStaffId() == staffId).
                                findAny();
    }

    public void delete (EmployeeAddress employeeAddress) {
        employeeAddressDB.remove(employeeAddress);
    }

    public List<EmployeeAddress> getAll(String staffId) {
        return repository.getAll(staffId);
    }
}
