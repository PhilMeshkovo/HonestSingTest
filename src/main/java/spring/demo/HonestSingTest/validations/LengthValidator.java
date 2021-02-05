package spring.demo.HonestSingTest.validations;

import spring.demo.HonestSingTest.annotations.LengthValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LengthValidator implements ConstraintValidator<LengthValid, String> {

    @Override
    public void initialize(LengthValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return string.length() == 9;
    }
}
