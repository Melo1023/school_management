package za.ac.cput.schoolmanagement.service.country;
/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country Service interface
 Due date: 18 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface CountryService extends IService<Country, String> {
    List<Country> findAll();
    void delete(String id);
}
