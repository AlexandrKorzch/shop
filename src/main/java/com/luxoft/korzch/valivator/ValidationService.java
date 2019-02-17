package com.luxoft.korzch.valivator;

import com.luxoft.korzch.exceptions.UnrealAgeException;
import com.luxoft.korzch.exceptions.WrongEmailException;
import com.luxoft.korzch.exceptions.WrongPhoneException;

public class ValidationService {

    private static final String EMAIL_PATTERN  = "\\w+@\\w+\\.\\w+";
    private static final String PHONE_PATTERN  = "\\((067|068|097|063|073|098|091|093)\\)-\\d{3}-\\d{2}-\\d{2}";
    private static final int MAX_AGE  = 150;
    private static final int MIN_AGE  = 18;

    public static boolean validateAge(int age) throws UnrealAgeException {
        if (age > MAX_AGE || age < MIN_AGE) {
            throw new UnrealAgeException("Unreal age");
        }
        return true;
    }

    public static boolean validatePhone(String phone) throws WrongPhoneException {
        if(phone.matches(PHONE_PATTERN)){
            return true;
        }else{
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
}
