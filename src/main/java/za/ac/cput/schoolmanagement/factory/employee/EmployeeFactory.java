package za.ac.cput.schoolmanagement.factory.employee;

/*
    Student: Ian Louw
    Student Number: 216250773
    Class for the Employee factory.
    Date: 11 June 2022
 */

import za.ac.cput.schoolmanagement.domain.employee.Employee;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.Helper;

public class EmployeeFactory {

    public static Employee createEmployeeFactory(String staffId, String email, Name name) {

        if (Helper.isNullOrEmpty(staffId))
            return null;

        if (!Helper.isValidEmail(email))
            return null;

        if (name == null)
            return null;

        Employee employee = new Employee.Builder().setStaffId(staffId).
                setEmail(email).
                setName(name).
                build();
        return employee;
    }

}
