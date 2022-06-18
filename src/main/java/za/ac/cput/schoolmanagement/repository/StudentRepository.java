/*
    StudentRepository.java
    Repository for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */


package za.ac.cput.schoolmanagement.repository;

//import za.ac.cput.schoolmanagement.Domain.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Student.StudentId> {


   Student findByStudentId (String StudentId);


}


