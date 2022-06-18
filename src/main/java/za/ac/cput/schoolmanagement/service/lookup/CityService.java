/*
CityService.java
This is the City service class
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.service.lookup;

import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.lookup.City;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

@Service

public interface CityService extends IService<City, String> {
    List<City> findAll();
    void delete(String id);

    List<City> getAll(String cityId);

    void deleteById(String id);
}
