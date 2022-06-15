/*
CityService.java
This is the City service class
Author: Felecia Zweni 218330189
Date: 13/06/2022
 */

package za.ac.cput.schoolmanagement.service.City;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface CityService extends IService<City, String> {
    List<City> findAll();
    void delete(String id);
}
