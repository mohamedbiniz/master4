package com.master4.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.TYPE )
@Constraint(validatedBy = PasswordClass.class)
@Documented
public @interface Password {
    String message() default "passwords are not the same ";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
