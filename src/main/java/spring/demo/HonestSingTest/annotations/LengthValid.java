package spring.demo.HonestSingTest.annotations;

import spring.demo.HonestSingTest.validations.LengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LengthValidator.class)
@Documented
public @interface LengthValid {
    String message() default "Длина id покупателя и продавца должна составлять 9 символов";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
