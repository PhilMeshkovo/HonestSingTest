package spring.demo.HonestSingTest.validations;

import spring.demo.HonestSingTest.annotations.CodeLengthValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CodeLengthValidator implements ConstraintValidator<CodeLengthValid, String> {
    @Override
    public void initialize(CodeLengthValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
        return string.length() == 13;
    }
}
