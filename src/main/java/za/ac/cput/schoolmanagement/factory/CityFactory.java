/*
CityFactory.java
This is the City factory class
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;

import za.ac.cput.schoolmanagement.helper.Helper;

public class CityFactory {

    public static City createCity(String id){

        if (Helper.isNullOrEmpty(id) || Helper.isNullOrEmpty(id))
            return null;

        City city = new City.Builder()
                .setId(id)
                .build();
        return city;

    }
}
