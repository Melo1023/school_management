/*
    StudentFactory.java
    Factory for Student
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.helper.Helper;

import javax.xml.namespace.QName;

public class StudentFactory {

    public static Student createStudent (
            String studentId,
            String email,
            QName name
    ){
        if (
        Helper.isNullOrEmpty(studentId) || Helper.isValidEmail(email)
        )

            throw new IllegalArgumentException( "Incorrect details : enter valid details");

          return new za.ac.cput.schoolmanagement.domain.Student.Builder()
                  .setStudentId(studentId)
                  .setEmail(email)
                  .setName(name)
                  .build();
    }
}

