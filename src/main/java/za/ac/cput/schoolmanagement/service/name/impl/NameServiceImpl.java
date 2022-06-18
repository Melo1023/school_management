/* NameRepository.java
   This is a Name Service class
   Author: Vuyisa Nkangana
   Student No: 218192215
   Due Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.name.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.repository.name.NameRepository;
import za.ac.cput.schoolmanagement.service.name.NameService;

import java.util.List;
import java.util.Optional;

public class NameServiceImpl implements NameService {
    private final NameRepository repository;
    @Autowired
    public NameServiceImpl(NameRepository repository) {
        this.repository = repository;
    }
    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(String lastName) {
        return repository.findById(lastName);
    }

    @Override
    public void delete(Name name) {
    this.repository.delete(name);
    }

    @Override
    public List<Name> findAll() {
        return this.repository.findAll();
    }

    @Override
    public void delete(String lastName) {
        Optional<Name> name = read(lastName);
        if(name.isPresent()) delete(name.get());
    }
}

