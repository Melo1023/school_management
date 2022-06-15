package za.ac.cput.schoolmanagement.factory;

/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country factory Test case
 Due date: 18 June 2022
 */

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.schoolmanagement.domain.Country;
import static org.junit.jupiter.api.Assertions.*;

class CountryFactoryTest {
    @Test
    public void test () {
        Country country = CountryFactory.createCountry("27", "South Africa");
        System.out.println(country.toString());
        assertNotNull(country);
    }

    @Test
    public void testWithNullValue() {
        Country country = CountryFactory.createCountry(null, "South Africa");
        System.out.println(country);
    }
    @Test
    @Timeout(2)
    void buildWithTimeout() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("Test timed out !");
    }
}