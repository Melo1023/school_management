/*
CityRepository.java
This is the City
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.repository.lookup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.lookup.City;


import java.util.List;

@Repository

public interface CityRepository extends JpaRepository<City, String> {
    List<City> findAll();
}
