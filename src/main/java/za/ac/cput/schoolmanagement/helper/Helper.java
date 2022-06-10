package za.ac.cput.schoolmanagement.helper;

import java.util.UUID;

public class Helper {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isNullOrEmpty(String s) {
        return (s == null || s.equals("") || s.isEmpty() || s.equalsIgnoreCase("null"));
    }

    public static boolean nameIsNullOrEmpty (Name n) {

        return (n == null || n.equals(""));
    }

    public static boolean addressIsNullOrEmpty (Address a) {

        return (a == null || a.equals(""));
    }

}
