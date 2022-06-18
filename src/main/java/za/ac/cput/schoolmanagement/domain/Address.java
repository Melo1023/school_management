package za.ac.cput.schoolmanagement.domain;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Class for Address entity.
    Date: 9 June 2022
 */

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable  {


    private String unitNumber;
    private String complexName;
    private String streetNumber;
    private String streetName;
    private int postalCode;
    @ManyToOne(targetEntity = City.class, cascade = CascadeType.ALL)
    private City city;

    public Address() {
    }

    public Address(Builder builder) {
        this.unitNumber = unitNumber;
        this.complexName = complexName;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.city = city;
    }


    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return postalCode == address.postalCode && unitNumber.equals(address.unitNumber) && complexName.equals(address.complexName) && streetNumber.equals(address.streetNumber) && streetName.equals(address.streetName) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unitNumber, complexName, streetNumber, streetName, postalCode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                '}';

    }
    public static class Builder {

        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(City city) {
         this.city = city;
         return this;
       }
        public Address build () {

            return new Address(this);
        }

        public Builder copy (Address Address) {
            this.unitNumber = unitNumber;
            this.complexName = complexName;
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.postalCode = postalCode;
            this.city = city;

            return this;
    }



    }
    public static class AddressId{
        private String unitNumber,streetNumber;

        public AddressId(String unitNumber, String streetNumber) {
            this.unitNumber = unitNumber;
            this.streetNumber = streetNumber;
        }

        public String getUnitNumber() {
            return unitNumber;
        }

        public String getStreetNumber() {
            return streetNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AddressId addressId = (AddressId) o;
            return unitNumber.equals(addressId.unitNumber) && streetNumber.equals(addressId.streetNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(unitNumber, streetNumber);
        }
    }
}
