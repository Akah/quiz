package com.rob.quiz.validator;

import com.rob.quiz.model.MongoUser;
import com.rob.quiz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Override
    public boolean supports(Class<?> aClass) {
        return MongoUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MongoUser user = (MongoUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME, "NotEmpty");
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue(USERNAME, "Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue(USERNAME, "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD, "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue(PASSWORD, "Size.userForm.password");
        }

// might fail without this
//        if (!user.getPasswordConfirm().equals(user.getPassword())) {
//            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
//        }
    }
}
