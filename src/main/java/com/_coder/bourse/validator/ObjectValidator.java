package com._coder.bourse.validator;

import com._coder.bourse.exception.ObjectValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator <T>{

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    public void validate(T objectToValidate) {

        //get the violations
        Set<ConstraintViolation<T>>  violations = validator.validate(objectToValidate);

        //check if there are violations and get the massage error
        if(!violations.isEmpty()){
            Set<String> errorMassage =
                    violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());

            //todo throw an exception
            throw new ObjectValidationException(errorMassage,objectToValidate.getClass().getName());

        }
    }
}
