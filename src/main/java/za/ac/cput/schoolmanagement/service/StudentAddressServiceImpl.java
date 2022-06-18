/*
    StudentAddressServiceImpl.java
    StudentAddressServiceImpl for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.repository.StudentAddressRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {
    private final StudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImpl(StudentAddressRepository repository){
        this.repository =repository;
    }

    @Override
    public StudentAddressService save(StudentAddressService studentAddress) {
//        return this.repository.save(studentAddress);
        return null;
    }

    @Override
    public Optional<StudentAddressService> read(String id) {
        return this.repository.findAllById(id);
//        return Optional.empty();
    }

    @Override
    public void delete(StudentAddressService studentAddress) {
//        this.repository.delete(za.ac.cput.schoolmanagement.domain.StudentAddress);

    }

    @Override
    public za.ac.cput.schoolmanagement.domain.StudentAddress create(za.ac.cput.schoolmanagement.domain.StudentAddress studentAddress) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<StudentAddressService> studentAddress =read(id);
        if
        (studentAddress.isPresent())
        {
        delete(studentAddress.get());

    }}

    @Override
    public List<StudentAddress> findAll() {
        return this.repository.findAll();
    }
}