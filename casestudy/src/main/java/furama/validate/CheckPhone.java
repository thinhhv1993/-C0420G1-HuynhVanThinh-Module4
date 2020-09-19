package furama.validate;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = CheckPhoneValidator.class)
@Retention(RUNTIME)
@Target({FIELD, METHOD})
public @interface CheckPhone {
    String message() default "{org.hibernate.validator.referenceguide.chapter06.CheckCase." +
            "message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
