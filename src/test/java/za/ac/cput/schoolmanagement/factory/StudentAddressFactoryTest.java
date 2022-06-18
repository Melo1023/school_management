/*
    StudentAddressFactoryTest.java
    FactoryTest for StudentAddress
    Student:Hlumelo Mpotulo
    Student Number: 215226348
    Due Date 09 June 2022
 */


package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentAddressFactoryTest {

      private static StudentAddress studentAddress = StudentAddressFactory.createStudentAddress("215226348","18849 Dyamala Road");

      @Test
      void createStudentAddressSuccess() throws IllegalArgumentException{
          StudentAddress studentAddress1 =StudentAddressFactory.createStudentAddress("2322", "507 Fig Street ");
          assertNotNull(studentAddress1);
          assertEquals("18849",studentAddress1.getAddress());
      }

    private void assertEquals(String s, Address address) {
    }

    @Test
    void createStudentAddressFail(){
          assertThrows(IllegalArgumentException.class, ()->{
              StudentAddressFactory.createStudentAddress("454635", "5466");
          });
        System.out.println("An error occured");
    }

}