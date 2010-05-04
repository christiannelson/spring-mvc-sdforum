package xian.recipes.model;

import org.apache.commons.collections15.CollectionUtils;
import org.apache.commons.collections15.Predicate;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/xian/recipes/application-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class IngredientValidationTest
{
    @Autowired
    Validator validator;

    @Test
    public void shouldRequireQuantityAndName()
    {
        Ingredient ingredient = new Ingredient(null, null, null);
        assertThat(fieldViolations(ingredient, "name").isEmpty(), is(false));
        assertThat(fieldViolations(ingredient, "quantity").isEmpty(), is(false));
    }

    @Test
    public void shouldRequireQuanitytAmountAndUnits()
    {
        Ingredient ingredient = new Ingredient("Apples", new Quantity(), null);
        assertThat(fieldViolations(ingredient, "quantity.amount").isEmpty(), is(false));
        assertThat(fieldViolations(ingredient, "quantity.units").isEmpty(), is(false));
    }

    @Test
    public void shouldAllowValidIngredients()
    {
        Ingredient ingredient = new Ingredient("Apples", new Quantity(new BigDecimal("2"), Unit.WHOLE), "cubed");
        assertThat(validator.validate(ingredient).isEmpty(), is(true));
    }

    private Set<ConstraintViolation<Ingredient>> fieldViolations(Ingredient ingredient, String fieldName)
    {
        Set<ConstraintViolation<Ingredient>> violations = validator.validate(ingredient);
        CollectionUtils.filter(violations, new ConstraintViolationPredicate(fieldName));
        return violations;
    }

    private static class ConstraintViolationPredicate implements Predicate<ConstraintViolation<Ingredient>>
    {
        private final String fieldName;

        private ConstraintViolationPredicate(String fieldName)
        {
            this.fieldName = fieldName;
        }

        @Override
        public boolean evaluate(ConstraintViolation<Ingredient> violation)
        {
            return StringUtils.equals(fieldName, violation.getPropertyPath().toString());
        }
    }
}