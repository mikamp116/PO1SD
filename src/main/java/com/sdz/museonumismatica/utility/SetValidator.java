package com.sdz.museonumismatica.utility;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.TreeSet;


public class SetValidator implements ConstraintValidator<SetConstraint, TreeSet> {
    @Override
    public void initialize(SetConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(TreeSet setField, ConstraintValidatorContext constraintValidatorContext) {
        return setField!=null && setField.size()>0;
    }
}
