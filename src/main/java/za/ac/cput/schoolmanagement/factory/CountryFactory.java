package za.ac.cput.schoolmanagement.factory;
/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country factory class
 Due date: 18 June 2022
 */
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.Helper;

public class CountryFactory {

    public static Country createCountry(String id, String name) {
        if (Helper.isNullOrEmpty(id) || Helper.isNullOrEmpty(name))
            return null;

     Country country = new Country.Builder()
             .setId(id)
             .setName(name)
             .build();
     return country;
    }
}

