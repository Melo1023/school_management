/*
    StudentAddressService.java
    StudentAddressService for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Student;

import java.util.Optional;

public interface StudentAddress extends IService <StudentAddress, String> {

    Optional<StudentAddress> read(Student.StudentId studentId);

    void delete(StudentAddress studentAddress);

}


