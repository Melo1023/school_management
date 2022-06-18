/*
    StudentAddressService.java
    StudentAddressService for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.List;

public interface StudentAddressService extends IService <StudentAddressService, String> {

    za.ac.cput.schoolmanagement.domain.StudentAddress create(za.ac.cput.schoolmanagement.domain.StudentAddress studentAddress);

    void deleteById(String id);

    List<StudentAddress> findAll();

//    void delete(String a);

}


