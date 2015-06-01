package com.springapp.mvc.validation;

import com.springapp.mvc.domain.MemberOfFamily;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component

public class MemberValidation implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberOfFamily.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login", "required.login", "Error login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "required.password", "Error password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"age", "required.age", "Error age");


    }
}
