/*
    StudentRepository.java
    Repository for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.repository;

import za.ac.cput.schoolmanagement.domain.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImpl implements IStudentRepository {
    private final List<za.ac.cput.schoolmanagement.domain.Student> StudentList;
    private static StudentRepositoryImpl repository;
    private za.ac.cput.schoolmanagement.domain.Student Student;

    public StudentRepositoryImpl(){
        this.StudentList = new ArrayList<>();
    }

    public static StudentRepositoryImpl getRepository(){
        if (repository == null)
            repository = new StudentRepositoryImpl();
        return repository;
    }


    @Override
    public za.ac.cput.schoolmanagement.domain.Student delete(String StudentId) {
        this.StudentList.remove(Student);
        return null;
    }

    @Override
    public za.ac.cput.schoolmanagement.domain.Student save(String StudentId) {
        Optional<Student>read = read(Student.getStudentId());
        if (read.isPresent()){
            delete(String.valueOf(read.get()));
        }
        this.StudentList.add(Student);
        return Student;
    }

    @Override
    public Optional<Student> read(String StudentId) {
        return this.StudentList.stream().filter(g -> g.getStudentId().equalsIgnoreCase(StudentId))
                .findFirst();
    }


    @Override
    public za.ac.cput.schoolmanagement.domain.Student readAll(String StudentId) {
        return null;
    }
}
