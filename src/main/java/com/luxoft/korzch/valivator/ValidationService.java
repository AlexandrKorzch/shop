package com.luxoft.korzch.valivator;

import com.luxoft.korzch.exceptions.UnrealAgeException;

public class ValidationService {

    boolean validateAge(int age) throws UnrealAgeException {
        if(age > 150 ||age < 0){
            throw new UnrealAgeException("Unreal age");
        }
        return true;
    }
}
