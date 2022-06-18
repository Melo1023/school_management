package za.ac.cput.schoolmanagement.service.lookup;
/*
 @Author: Lihle Njobe
 Student number : 218193882
 This is Country Service interface
 Due date: 18 June 2022
 */

import za.ac.cput.schoolmanagement.domain.lookup.Country;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface CountryService extends IService<Country, String> {
    List<Country> getAll(String CountryId);
    void deleteById(String id);

}
