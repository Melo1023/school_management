package za.ac.cput.schoolmanagement.repository;


import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.List;
import java.util.Optional;
/*
    Student.java
    IRepository for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
public interface IStudentAddress extends JpaRepository<StudentAddress, String> {

    void delete (String studentId);
    StudentAddress update (String studentId);
    Optional<Object> readAll (String studentId);
    List<StudentAddress> save (String studentId);



}
