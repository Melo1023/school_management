/*
CityRepository.java
This is the City
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.repository.City;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.schoolmanagement.domain.City;


import java.util.List;

public interface CityRepository extends JpaRepository<City, String> {
    List<City> findAll();
}
