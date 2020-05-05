package com.master4.validators;

import com.master4.entities.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class PasswordClass implements ConstraintValidator<Password,User> {
    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        return value.getPassword().equals(value.getConfirmedPassword());
    }
}
