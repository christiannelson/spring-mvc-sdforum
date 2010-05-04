package xian.recipes.model;

import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static xian.recipes.model.User.newUser;

public class UserValidatorTest
{
    @Test
    public void shouldAcceptValidEmail()
    {
        assertValidEmail(newUser("cnelson@example.com", "Christian Nelson"));
        assertValidEmail(newUser("a@a.ca", "A"));
    }

    @Test
    public void shouldRejectInvalidEmail()
    {
        assertInvalidEmail(newUser("cnelson@example.c", "Christian Nelson"));
        assertInvalidEmail(newUser("c nelson@example.com", "Christian Nelson"));
        assertInvalidEmail(newUser(" cnelson@example.com", "Christian Nelson"));
        assertInvalidEmail(newUser("cnelson@example.com ", "Christian Nelson"));
    }

    private void assertValidEmail(User user)
    {
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(user, "user");
        new UserValidator().validate(user, errors);
        assertThat(errors.getFieldErrors("email").size(), is(0));
    }

    private void assertInvalidEmail(User user)
    {
        BeanPropertyBindingResult errors = new BeanPropertyBindingResult(user, "user");
        new UserValidator().validate(user, errors);
        assertThat(errors.getErrorCount(), is(greaterThan(0)));
        assertThat(errors.getFieldError("email").getCode(), is("email.invalid"));
    }
}
