package com.sdz.museonumismatica.utility;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FloatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FloatConstraint {
    String message() default "No se encontró número decimal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}