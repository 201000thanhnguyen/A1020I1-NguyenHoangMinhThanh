package com.example.register.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstaint {
    String message() default "Email da ton tai";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
