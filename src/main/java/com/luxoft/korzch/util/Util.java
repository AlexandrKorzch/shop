package com.luxoft.korzch.util;

import java.util.List;

import static com.luxoft.korzch.common.Constants.FAIL;

public class Util {

    public static void closeProgram() {
        System.exit(0);
    }

    public static long idToLong(String stringId) {
        try {
            return Long.parseLong(stringId);
        } catch (NumberFormatException e) {
            return FAIL;
        }
    }

    public static int ageToInt(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return (int) FAIL;
        }
    }

    public static double priceToDouble(String price) {
        try {
            return Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return FAIL;
        }
    }

    public static boolean isNotNullNotEmpty(List<?> list) {
        if (list == null) {
            return false;
        } else {
            return !list.isEmpty();
        }
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static boolean successId(long id) {
        return id > FAIL;
    }
}