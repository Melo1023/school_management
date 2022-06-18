package za.ac.cput.schoolmanagement.service.lookup;

/*
    Student: Bongisa Mpahleni
    Student Number: 216205999
    Date: 9 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.service.IService;
import java.util.List;

public interface AddressService extends IService<Address, String> {
    List<Address> getAll(String unitNumber);
    void deleteById(String unitNumber);
}