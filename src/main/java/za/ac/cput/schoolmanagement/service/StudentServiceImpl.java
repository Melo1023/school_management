package za.ac.cput.schoolmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private static StudentService studentService =null;


    @Autowired
    private StudentRepository studentRepository;

    private StudentServiceImpl (){

    }
   public static StudentService studentService(){
        if (studentService == null) studentService = new StudentServiceImpl();
        return studentService;
   }

   @Override
    public List<Student> getAll(){
        return this.studentRepository.findAll();
   }


    @Override
    public Object save(Object o) {
        return null;
    }


    @Override
    public Optional read(String student) {
        return this.studentRepository.save(String student);
    }

    @Override
    public void delete(String StudentId) {
        Optional<Student> student = read(StudentId);
        if (StudentId.isEmpty()) delete(Student.get());
        

    }
}

