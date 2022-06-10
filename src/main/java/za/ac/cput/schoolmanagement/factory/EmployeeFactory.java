package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.helper.Helper;

public class EmployeeFactory {

    public static Employee createEmployeeFactory(String staffId, String email, Name name) {

        if (Helper.isNullOrEmpty(staffId) || Helper.isNullOrEmpty(email))
            return null;

        if (Helper.nameIsNullOrEmpty(name))
            return null;

        Employee employee = new Employee.Builder().setStaffId(staffId).
                setEmail(email).
                setName(name).
                build();
        return employee;
    }
}
