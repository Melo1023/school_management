package za.ac.cput.schoolmanagement.service.Student;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.domain.lookup.Country;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;
import za.ac.cput.schoolmanagement.factory.lookup.CityFactory;
import za.ac.cput.schoolmanagement.factory.lookup.CountryFactory;
import za.ac.cput.schoolmanagement.service.StudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentAddressServiceImplTest {

    private static final StudentAddress studentAddress = StudentAddressFactory.createStudentAddress("235453","18846 DD road");
    private static final City city = CityFactory.createCity("67","JHB");
    private static final Country country = CountryFactory.createCountry("87","SA");

    @Autowired
    private StudentAddressService studentAddressService;


    @Test
    void save(){
        StudentAddressService saved = this.studentAddressService.save(this.studentAddressService);
        assertEquals(this.studentAddressService, saved);
        System.out.println(saved);
    }
    @Test
    void read(){
        Optional<StudentAddressService> read = this.studentAddressService.read(studentAddress.getStudentId());
       assertAll(
               ()-> assertTrue(read.isPresent()),
        ()-> assertEquals(this.studentAddressService,read.get())
       );

    }

    @Test
    void findAll(){
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(1,studentAddressList.size());
    }

    @Test
    void delete(){
        this.studentAddressService.deleteById(this.studentAddress.getStudentId());
        List<StudentAddress> studentAddressList = this.studentAddressService.findAll();
        assertEquals(0,studentAddressList.size());
    }

}