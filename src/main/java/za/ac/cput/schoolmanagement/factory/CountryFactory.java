package za.ac.cput.schoolmanagement.factory;
/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country factory class
 Due date: 18 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.Helper.Helper;

public class CountryFactory {

    public static Country createCountry(String name) {
     String id = Helper.generateId();
     Country country = new Country.Builder()
             .setId(id)
             .setName(name)
             .build();
     return country;
    }
}

