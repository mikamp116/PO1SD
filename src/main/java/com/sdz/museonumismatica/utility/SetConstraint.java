package com.sdz.museonumismatica.utility;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SetValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetConstraint {
    String message() default "La cadena introducida no sigue las reglas de entrada";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}