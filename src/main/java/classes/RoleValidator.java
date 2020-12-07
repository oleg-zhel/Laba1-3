package classes;


import interfaces.RoleConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<RoleConstraint,Integer> {

    @Override
    public boolean isValid(Integer role, ConstraintValidatorContext constraintValidatorContext) {
        return role>=0&&role<=1;
    }
}
