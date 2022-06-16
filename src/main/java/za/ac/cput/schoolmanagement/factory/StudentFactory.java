/*
    StudentFactory.java
    Factory for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.helper.Helper;

public class StudentFactory {

    public static Student createStudent (
            String studentId,
            String email,
            Name name
    ){
        if (
        Helper.isNullOrEmpty(studentId) || Helper.isValidEmail(email) || name == null
        )

            throw new IllegalArgumentException( "Incorrect details : enter valid details");

          return new za.ac.cput.schoolmanagement.domain.Student.Builder()
                  .setStudentId(studentId)
                  .setEmail(email)
                  .setName(name)
                  .build();
    }

    public static Student createStudent(String studentId, String email, String s) {
        return null;
    }
}

