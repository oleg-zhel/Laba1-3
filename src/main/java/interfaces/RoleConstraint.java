package interfaces;

import classes.RoleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleValidator.class)
public @interface RoleConstraint {
    String message() default "Car seats must be >= 2";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
