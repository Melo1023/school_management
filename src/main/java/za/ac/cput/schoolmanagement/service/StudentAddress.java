/*
    StudentAddressService.java
    StudentAddressService for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.service;

public interface StudentAddress extends IService <StudentAddress, String> {

    za.ac.cput.schoolmanagement.domain.StudentAddress create(za.ac.cput.schoolmanagement.domain.StudentAddress studentAddress);

    void deleteById(String id);

}


