/*
CityFactoryTest.java
This is the City factory test class
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.schoolmanagement.domain.City;


import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CityFactoryTest {

    @Test
    public void test () {
        City city = CityFactory.createCity("27", "Stellenbosch");
        System.out.println(city.toString());
        assertNotNull(city);
    }

    @Test
    public void testWithNullValue() {
        City city = CityFactory.createCity(null, "Stellenbosch");
        System.out.println(city);
    }
    @Test
    @Timeout(2)
    void buildWithTimeout() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Test timed out !");
    }
}
