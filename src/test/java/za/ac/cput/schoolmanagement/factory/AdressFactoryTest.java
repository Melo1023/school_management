package za.ac.cput.schoolmanagement.factory;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.lookup.City;


import static org.junit.jupiter.api.Assertions.*;

class AdressFactoryTest {

    @BeforeEach
    void setUp() {
        City city = new City.Builder().setName("cape town").build();
        Address address = AdressFactory.build("1212","A","1414","LONG STREET",7785,city);
    }


    @Test
    public void buildWithSuccess(){

        City city = new City.Builder().setName("cape town").build();
        Address address = AdressFactory.build("dfgg","a","1414","LONG STREET",7785,city);
        assertNotNull(address);
    }
    @Test
    void buildWithError(){
        City city = new City.Builder().setName("cape town").build();
        Exception exception = assertThrows(IllegalArgumentException.class, () ->AdressFactory.build("","A","1414","LONG STREET",7785,city));
        String exceptionMessage = exception.getMessage();
        assertSame("UnitNumber is required",exceptionMessage);
        System.out.println(exceptionMessage);

    }
}