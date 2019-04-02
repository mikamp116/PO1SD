package com.sdz.museonumismatica.utility;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author Víctor Fernández
 *
 * Esta clase es la anotación que permite usar el validador de números decimales
 */

@Documented
@Constraint(validatedBy = FloatValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FloatConstraint {
    String message() default "No se encontró número decimal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}