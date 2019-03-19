package test;

import com.luxoft.korzch.exceptions.NotAllowedAgeException;
import com.luxoft.korzch.exceptions.WrongEmailException;
import com.luxoft.korzch.exceptions.WrongPhoneException;
import org.junit.Test;

import static com.luxoft.korzch.valivator.ValidationService.*;
import static org.junit.Assert.*;

public class ValidationServiceTest {

    @Test
    public void validateAgeTest() throws NotAllowedAgeException{
        assertTrue(validateAge(18));
        assertTrue(validateAge(40));

        try {
            validateAge(160);
            fail();
        }catch (NotAllowedAgeException e){
            assertEquals("Wrong age", e.getMessage());
        }

        try {
            validateAge(17);
            fail();
        }catch (NotAllowedAgeException e){
            assertEquals("Wrong age", e.getMessage());
        }
    }

    @Test
    public void validatePhoneTest() {
        try {
            validatePhone("+380683777458");
            fail();
        }catch (WrongPhoneException e){
            assertEquals("Wrong phone format", e.getMessage());
        }

        try {
            validatePhone("oarnstiarniostnoiar");
            fail();
        }catch (WrongPhoneException e){
            assertEquals("Wrong phone format", e.getMessage());
        }
        assertTrue(validatePhone("(068)-377-74-58"));
        assertTrue(validatePhone("(067)-334-74-78"));
        assertTrue(validatePhone("(093)-377-77-74"));
        assertTrue(validatePhone("(068)-987-74-48"));
    }

    @Test
    public void validateEmailTest() {
        try {
            validateEmail("resth@risnt");
            fail();
        }catch (WrongEmailException e){
            assertEquals("Wrong email format", e.getMessage());
        }

        try {
            validateEmail("oarnstiarniostnoiar");
            fail();
        }catch (WrongEmailException e){
            assertEquals("Wrong email format", e.getMessage());
        }
        assertTrue(validateEmail("arsrstrstrstt@rst.rst"));
        assertTrue(validateEmail("arst@rstrstrstrstrst.rst"));
        assertTrue(validateEmail("arst@rst.rstrstrstrstrst"));
    }
}