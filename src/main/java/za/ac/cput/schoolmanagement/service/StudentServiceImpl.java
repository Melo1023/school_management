/*
    StudentServiceImpl.java
    StudentServiceImpl for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student create(Student student){

        return repository.save(student);
    }

    @Override
    public Student update(Student student){

        return repository.save(student);
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> read(String studentId){
        return Optional.ofNullable(repository.findByStudentId(studentId));
    }

    @Override
    public void delete(Student student){
        System.out.println(student);
        repository.delete(student);
    }

    public List<Student>getAll(){
        return repository.findAll();
    }


}