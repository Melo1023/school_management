package za.ac.cput.schoolmanagement.factory;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for EmployeeAddressFactory.
    Date: 11 June 2022
 */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.helper.Helper;

public class EmployeeAddressFactory {


    public static EmployeeAddress createEmployeeAddress(String staffId, Address address) {

        if (Helper.isNullOrEmpty(staffId))
            return null;

        if (address == null)
            return null;

        EmployeeAddress employeeAddress = new EmployeeAddress.Builder().
                setStaffId(staffId).
                setAddress(address).
                build();
        return employeeAddress;
    }

}
