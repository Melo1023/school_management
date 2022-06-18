package za.ac.cput.schoolmanagement.service.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;
import za.ac.cput.schoolmanagement.service.StudentServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceImplTest {
    

    @Autowired
    private StudentServiceImpl studentService;
    private static Student student = StudentFactory.createStudent("575","mpot@web.com","Nosipo");
    private static Name name = NameFactory.createName("Njeza","Nosipo","Xulu");

    @Test
    void h_start(){
        assertNotNull (studentService.create(student));
    }

    private void assertNotNull(Student student) {
    }

    @Test
    void studentService() {

    }

    @Test
    //insert Name stuff
    void create() {
        assertNotNull(studentService.create(student));

    }

    @Test

    void read (){
        assertEquals("5656", studentService.read("678"));
        Optional<Student> s = studentService.read("678");
        System.out.println(s.get());
    }

    @Test
    void update(){
        Student h = new Student.Builder().copy(student).setStudentId("5689").build();
        assertNotNull(studentService.create(h));
    }

    @Test
    void delete(){
        studentService.delete(student);
    }

    @Test
    void getAll() {

        assertEquals(1,studentService.getAll().size());
    }
}