package wiscom.backend.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import wiscom.backend.apiPayload.code.status.ErrorStatus;
import wiscom.backend.validation.annotation.PageCheck;

@Component
public class CheckPageResolver implements ConstraintValidator<PageCheck, Integer> {

    @Override
    public void initialize(PageCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer pageValue, ConstraintValidatorContext context) {
        boolean isValid = (pageValue >= 0);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.PAGE_EXCEPTION.toString()).addConstraintViolation();
            return false;
        }

        return true;
    }
}