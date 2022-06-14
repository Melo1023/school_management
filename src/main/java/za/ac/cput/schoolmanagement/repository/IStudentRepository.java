/*
    IStudentRepository.java
    IRepository for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */


package za.ac.cput.schoolmanagement.repository;

//import za.ac.cput.schoolmanagement.Domain.Student;
import za.ac.cput.schoolmanagement.domain.Student;

import java.util.Optional;

public interface IStudentRepository implements JpaRepository<za.ac.cput.schoolmanagement.domain.Student, String> {

 Student delete (String StudentId );

 Student save (String StudentId);

 Optional<Student> read (String StudentId);

 Student readAll (String StudentId);




}


