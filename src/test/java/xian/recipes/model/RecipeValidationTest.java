package xian.recipes.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.validation.Validator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/xian/recipes/application-context.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class RecipeValidationTest
{
    @Autowired
    Validator validator;

    @Test
    public void shouldRequireValidIngredients()
    {
        // ...
    }
}
