/*
    StudentFactoryTest.java
    FactoryTest for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Student;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentFactoryTest {

     private static Student student = StudentFactory.createStudent("364474", "mpotuloh04@gmail.com","Cebo");

     @Test
     void createStudentSuccess()throws IllegalArgumentException{
         Student student1 = StudentFactory.createStudent("6345", "hlumelo@web.co.za","Lizo");
         assertNotNull(student1);
         assertEquals("student added", student1.getStudentId());
         System.out.println(student1.getName());
     }

     @Test
      void createStudentFail(){
         assertThrows(IllegalArgumentException.class, ()->{
             StudentFactory.createStudent("465","melo@webmail","Figo");
         });
         System.out.println("An error occured");
     }

    private void assertEquals(String student_added, String studentId) {

    }

    private void assertNotNull(Student student1) {
    }

}