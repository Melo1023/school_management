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

public interface StudentAddressService extends IService {

    List <StudentAddress> getAll();
}
