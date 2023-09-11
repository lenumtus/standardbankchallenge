package za.co.standardbankchallenge.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = UniqueIsbnValidationValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueIsbnValidation {

    String message() default "Some of The Fields are invalid";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
