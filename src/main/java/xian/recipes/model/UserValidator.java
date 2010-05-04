package xian.recipes.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isNotBlank;

public class UserValidator implements Validator
{
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^([^@\\s]+)@((?:[-a-z0-9]+\\.)+[a-z]{2,})$");

    @Override
    public boolean supports(Class<?> clazz)
    {
        return clazz.isAssignableFrom(User.class);
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        User user = (User) target;

        if (isNotBlank(user.getEmail()) && !EMAIL_PATTERN.matcher(user.getEmail()).find())
        {
            errors.rejectValue("email", "email.invalid", "invalid email address");
        }
    }
}
