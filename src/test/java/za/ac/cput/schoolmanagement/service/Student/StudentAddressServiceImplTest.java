package za.ac.cput.schoolmanagement.service.Student;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;
import za.ac.cput.schoolmanagement.service.StudentAddressServiceImpl;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentAddressServiceImplTest {


    @Autowired

    private StudentAddressServiceImpl studentAddressService;
    private static StudentAddress studentAddress = StudentAddressFactory.createStudentAddress("235453","18846 DD road");

    private static StudentAddress studentAddress1 = StudentAddressFactory.createStudentAddress("7656", "15143 Qonce Road");


    @Test
    void g_read (){

        assertNotNull(studentAddressService.read(studentAddress.getStudentId()));
        System.out.println(studentAddressService.read(studentAddress.getStudentId()));
    }

    @Test
    void h_update() {

        studentAddress = new StudentAddress.Builder().copy(studentAddress).setStudentId("43546").build();
        studentAddress = studentAddressService.update(studentAddress);
        assertEquals("43546", studentAddress.getStudentId());
        System.out.println(studentAddress.getStudentId());

//        @Test
//        void delete(){
//            studentAddressService.delete(studentAddress);
//        }
//
//
//        @Test
//        void i_getAll(){
//            assertEquals(2, studentAddressService.getAll().size());
//        }


    }



}