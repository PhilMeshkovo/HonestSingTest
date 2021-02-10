package spring.demo.HonestSingTest.annotations;

import spring.demo.HonestSingTest.validations.CodeLengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CodeLengthValidator.class)
@Documented
public @interface CodeLengthValid {
    String message() default "Длина кода продукта должна составлять 13 символов";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
