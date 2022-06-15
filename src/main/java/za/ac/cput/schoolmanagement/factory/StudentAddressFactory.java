/*
    Student.java
    Factory for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */

package za.ac.cput.schoolmanagement.factory;

import com.sun.nio.sctp.PeerAddressChangeNotification;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

public class StudentAddressFactory {

    public static StudentAddress createStudentAddress(
            String studentId,
            PeerAddressChangeNotification.AddressChangeEvent Address
    ){
        return  new StudentAddress.Builder()
                .setStudentId(studentId)
                .setAddress(Address)
                .build();

    }
}
