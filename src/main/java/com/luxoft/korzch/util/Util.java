package com.luxoft.korzch.util;

import java.util.List;

public class Util {

    public static void closeProgram() {
        System.exit(0);
    }

    public static long idToLong(String stringId) {
        try {
            return Long.parseLong(stringId);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int ageToInt(String age) {
        try {
            return Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static float priceToFloat(String price) {
        try {
            return Float.parseFloat(price);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String longToString(long id){
        return Long.toString(id);
    }

    public static boolean isNotEmpty(List<?> list){
        return !list.isEmpty();
    }

    public static boolean isNotNull(Object object){
        return object != null;
    }
}