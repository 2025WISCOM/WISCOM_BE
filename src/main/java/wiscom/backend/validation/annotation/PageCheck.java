package wiscom.backend.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import wiscom.backend.validation.validator.CheckPageResolver;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageResolver.class)
@Target( { ElementType.PARAMETER } )
@Retention(RetentionPolicy.RUNTIME)
public @interface PageCheck {

    String message() default "페이지 번호는 1보다 커야합니다";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}