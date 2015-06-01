package com.springapp.mvc.validation;


import com.springapp.mvc.domain.Cost;
import com.springapp.mvc.domain.MemberOfFamily;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CostValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Cost.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameCost", "required.nameCost", "Error name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.login", "Error login");

    }
}
