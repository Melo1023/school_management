package za.ac.cput.schoolmanagement.service.lookup.impl;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */


import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.lookup.AddressRepository;
import za.ac.cput.schoolmanagement.service.lookup.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository repository;
    private static AddressService service;



    public AddressServiceImpl () {
    }

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.repository=addressRepository;
    }

    public Address save (Address Address) {
        return repository.save(Address);
    }

    @Override
    public Optional<Address> read(String s) {
        return Optional.empty();
    }

    //public Optional<Address> read (Address.AddressId unitNumber) {
      //  return repository.findById(unitNumber);
   // }

    public void delete (Address Address) {
        repository.delete(Address);
    }

    public List<Address> getAll(String staffId) {
        return repository.findAll();
    }

    public void deleteById(String unitNumber) {
        Optional<Address> Address = read(unitNumber);
        if (Address.isPresent()) delete(Address.get());
    }
}
