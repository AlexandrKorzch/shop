package com.luxoft.korzch.valivator;

import com.luxoft.korzch.domain.Client;
import com.luxoft.korzch.exceptions.NotAllowedAgeException;
import com.luxoft.korzch.exceptions.WrongEmailException;
import com.luxoft.korzch.exceptions.WrongPhoneException;

import java.util.List;

public class ValidationService {

    private static final String EMAIL_PATTERN = "\\w+@\\w+\\.\\w+";
    private static final String PHONE_PATTERN = "\\((067|068|097|063|073|098|091|093)\\)-\\d{3}-\\d{2}-\\d{2}";
    private static final int MAX_AGE = 150;
    private static final int MIN_AGE = 18;

    public static boolean validateAge(int age) throws NotAllowedAgeException {
        if (age > MAX_AGE || age < MIN_AGE) {
            throw new NotAllowedAgeException("Wrong age");
        }
        return true;
    }

    public static boolean validatePhone(String phone) throws WrongPhoneException {
        if (phone.matches(PHONE_PATTERN)) {
            return true;
        } else {
            throw new WrongPhoneException("Wrong phone format");
        }
    }

    public static boolean validateEmail(String email) throws WrongEmailException {
        if (email.matches(EMAIL_PATTERN)) {
            return true;
        } else {
            throw new WrongEmailException("Wrong email format");
        }
    }

    public static <T extends Client>void validatePhoneNotExist(List<T> allClients, String phone) throws WrongPhoneException {
        for (T client : allClients) {
            if(client.getPhone().equals(phone)){
                throw new WrongPhoneException("This is engaged");
            }
        }
    }
}
