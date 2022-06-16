/*
    StudentService.java
    StudentService for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.service;

import za.ac.cput.schoolmanagement.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService extends IService <Student, String>{

    Student create(Student student);

    Student update(Student student);

    Optional<Student> read(String studentId);

    void delete(Student student);

    List<Student> getAll();
}
