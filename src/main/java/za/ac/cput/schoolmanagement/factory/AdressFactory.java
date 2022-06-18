package za.ac.cput.schoolmanagement.factory;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Class for AddressFactory .
    Date: 9 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.lookup.City;


public class AdressFactory {

    public static Address  build(String UnitNumber, String complexName, String streetNumber, String streetName, Integer postalCode, City city) {
        if(UnitNumber == null ||  UnitNumber.isEmpty())
            throw new IllegalArgumentException("UnitNumber is required");
        if( complexName == null ||  complexName.isEmpty())
            throw new IllegalArgumentException("complexName is required");
        if(streetNumber == null ||  streetNumber.isEmpty())
            throw new IllegalArgumentException("streetNumber is required");
        if( streetName == null ||  streetName.isEmpty())
            throw new IllegalArgumentException("StreetName is required");
        if(postalCode == null ||  postalCode==0)
           throw new IllegalArgumentException("postalCode is required");
        if( city == null )
            throw new IllegalArgumentException("city is required");
        Address address= new Address.Builder().setUnitNumber(UnitNumber).setComplexName(complexName).setStreetNumber(streetNumber).setStreetName(streetName).setPostalCode(postalCode).setCity(city).build();
        return address;
    }

}
