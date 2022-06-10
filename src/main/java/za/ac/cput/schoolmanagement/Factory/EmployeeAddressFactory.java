package za.ac.cput.schoolmanagement.Factory;

import za.ac.cput.schoolmanagement.Domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.Helper.Helper;

public class EmployeeAddressFactory {

    public static EmployeeAddress createEmployeeAddress(String staffId, Address address) {

        if (Helper.isNullOrEmpty(staffId))
            return null;

        if (Helper.addressIsNullOrEmpty(address))
            return null;

        EmployeeAddress employeeAddress = new EmployeeAddress.Builder().
                setStaffId(staffId).
                setAddress(address).
                build();
        return employeeAddress;
    }
}
