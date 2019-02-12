package com.luxoft.korzch.util;

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
}