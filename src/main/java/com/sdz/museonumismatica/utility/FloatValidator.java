package com.sdz.museonumismatica.utility;

import com.sdz.museonumismatica.utility.FloatConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FloatValidator implements ConstraintValidator<FloatConstraint, Float> {
    @Override
    public void initialize(FloatConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Float floatField, ConstraintValidatorContext constraintValidatorContext) {
        return floatField!=null && floatField > 0;
    }
}
