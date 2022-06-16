/*
    Student.java
    Factory for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.helper.Helper;

public class StudentAddressFactory {

    public static StudentAddress createStudentAddress(
            String studentId,
            Address Address
    ){
        if(
                Helper.isNullOrEmpty(studentId) || Address == null
        )
            throw new IllegalArgumentException("Incorrect Address");

        return  new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(Address)
                .build();

    }

    public static StudentAddress createStudentAddress(String studentId, String s) {
        return null;
    }
}
