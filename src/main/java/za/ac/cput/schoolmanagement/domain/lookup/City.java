/*
City.java
This is the City entity class
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.domain.lookup;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class City implements Serializable {

    @Id
    private String id;
    private String name;
    private Country country;

    public City(){

    }

    private City(Builder builder ){
        this.id = builder.id;
        this.name = builder.name;
        this.country = builder.country;

    }

    public String getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }

    public static class Builder{

        private String id;
        private String name;
        private Country country;

        public Builder setId( String id){
            this.id = id;
            return this;

        }

        public Builder setName(String name){
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country){
            this.country = country;
            return this;
        }

        public City build () {

            return new City(this);
        }

        public City.Builder copy (City city) {
            this.id = id;
            this.name = name;
            this.country = country;


            return this;
        }


    }
}
