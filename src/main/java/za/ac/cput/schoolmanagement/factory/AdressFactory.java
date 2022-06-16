package za.ac.cput.schoolmanagement.factory;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Class for AddressFactory .
    Date: 9 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.Helper;

public class AdressFactory {

    public static Address createAddress(String UnitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city) {




        Address address = new Address.Builder().
                setUnitNumber(UnitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode).
                 setCity(city).
                build();
        return address;
    }

}
