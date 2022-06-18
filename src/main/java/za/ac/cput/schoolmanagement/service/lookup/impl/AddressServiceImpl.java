package za.ac.cput.schoolmanagement.service.lookup.impl;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.lookup.AddressRepository;
import za.ac.cput.schoolmanagement.service.lookup.AddressService;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Optional<Address> read(String id) {
        return repository.findById(id);
    }

    @Override
    public void delete(Address address) {
        this.repository.delete(address);

    }

    @Override
    public List<Address> getAll(String unitNumber) {
        return repository.findAll();
    }

    @Override
    public void deleteById(String staffId) {
        Optional<Address> address = read(staffId);
        if (address.isPresent()) delete(address.get());
    }
}
