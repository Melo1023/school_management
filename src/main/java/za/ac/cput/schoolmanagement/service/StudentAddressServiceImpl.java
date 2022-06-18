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
import za.ac.cput.schoolmanagement.repository.StudentAddressRepository;

import java.util.Optional;

@Service
public class StudentAddressServiceImpl implements StudentAddress {

    @Autowired
   private StudentAddressRepository repository;
    private Object studentAddress;

    @Override
    public za.ac.cput.schoolmanagement.domain.StudentAddress create(za.ac.cput.schoolmanagement.domain.StudentAddress studentAddress){
        return this.repository.save(studentAddress);
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return null;
    }

    @Override
    public Optional<StudentAddress> read(String s) {
        return null;
    }

    @Override
    public void delete(StudentAddress studentAddress) {
        this.repository.delete((za.ac.cput.schoolmanagement.domain.StudentAddress) studentAddress);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
        Optional<StudentAddress> studentAddress =read(id);
        if(studentAddress.isPresent()) {
            delete(studentAddress.get());
        }
    }

}