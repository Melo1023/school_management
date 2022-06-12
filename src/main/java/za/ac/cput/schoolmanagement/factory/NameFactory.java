package za.ac.cput.schoolmanagement.factory;


import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.helper.Helper;

public class NameFactory {
    public static Name createName(String firstName, String middleName, String lastName) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName))
            return null;

        Name name = new Name.Builder()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setLastName(lastName)
                .build();
        return name;
    }
}
