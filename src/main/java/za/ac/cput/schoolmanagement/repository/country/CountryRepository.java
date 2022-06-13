package za.ac.cput.schoolmanagement.repository.country;

/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country Repository interface
 Due date: 18 June 2022
 */

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,String> {
    List<Country> findAll();

}
