package za.ac.cput.schoolmanagement.service.lookup.impl;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.service.lookup.AddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AddressServiceImplTest {


        private final City city = new City.Builder()
                .setId("20")
                .setName("cape town")
                .build();

        private final Address address = new Address.Builder()
                .setUnitNumber("2020")
                .setComplexName("A flats")
                .setStreetNumber("15")
                .setPostalCode(7785)
                .setCity(city)
                .build();

        @Autowired
        private AddressService service;

        @Test
        void save() {
            Address saved = service.save(address);
            String address1 = String.valueOf(address);
            String output = String.valueOf(saved);
            assertAll(
                    () -> assertNotNull(saved),
                    () -> assertEquals(address1, output)
            );
            System.out.println(saved);
        }

        @Test
        void read() {
            Address saved = service.save(address);
            Optional<Address> read = service.read(saved.getStreetNumber());
            System.out.println(read);
            String address1 = String.valueOf(saved);
            String output = String.valueOf(read.get());
            assertAll(
                    () -> assertTrue(read.isPresent()),
                    () -> assertEquals(address1, output)
            );
        }

        @Test
        void delete() {
            this.service.delete(address);
        }

        @Test
        void getAll() {
            Address saved = service.save(address);
            String staffId = saved.getStreetNumber();
            List<Address> AddressList = service.getAll(staffId);
            System.out.println(AddressList);
            assertSame(1, AddressList.size());
        }


    }
