package com.sdz.museonumismatica.utility;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @Author Víctor Fernández
 *
 * Esta clase sirve para validar los números decimales e integrar la validación con Spring y thymeleaf
 */
public class FloatValidator implements ConstraintValidator<FloatConstraint, Float> {
    @Override
    public void initialize(FloatConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Float floatField, ConstraintValidatorContext constraintValidatorContext) {
        return floatField!=null && floatField > 0;
    }
}
