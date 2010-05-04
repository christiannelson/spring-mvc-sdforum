package xian.recipes.web.controllers;

import org.apache.commons.collections15.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xian.recipes.RecipeRepository;
import xian.recipes.model.Ingredient;
import xian.recipes.model.Recipe;
import xian.recipes.model.Step;

import javax.validation.Valid;

import static org.apache.commons.collections15.CollectionUtils.filter;
import static org.apache.commons.lang.StringUtils.isNotBlank;

@Controller
@RequestMapping(value = "/recipes")
public class RecipesController
{
    @Autowired
    RecipeRepository recipeRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        // https://jira.springsource.org/browse/SPR-6437
        binder.setValidator(new DelegatingValidatorAdaptor(binder.getValidator()));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model)
    {
        model.addAttribute("recipes", recipeRepository.find());
        return "recipes/index";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model model)
    {
        Recipe recipe = recipeRepository.find(id);
        model.addAttribute("recipe", recipe);
        return "recipes/show";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newInstance(Model model)
    {
        model.addAttribute("recipe", new Recipe());
        return "recipes/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid Recipe recipe, BindingResult result)
    {
        if (result.hasErrors()) return "recipes/new";

        recipeRepository.save(recipe);
        return "redirect:/recipes";
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model)
    {
        Recipe recipe = recipeRepository.find(id);
        model.addAttribute("recipe", recipe);
        return "recipes/edit";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Long id, @Valid Recipe recipe, BindingResult result)
    {
        if (result.hasErrors()) return "recipes/edit";

        recipe.setId(id);
        recipeRepository.merge(recipe);
        return String.format("redirect:/recipes/%s", id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable Long id)
    {
        Recipe recipe = recipeRepository.find(id);
        recipeRepository.destroy(recipe);
        return "redirect:/recipes";
    }

    private void removeEmpties(Recipe recipe)
    {
        filter(recipe.getIngredients(), new Predicate<Ingredient>()
        {
            @Override
            public boolean evaluate(Ingredient ingredient)
            {
                return isNotBlank(ingredient.getName()) || (ingredient.getQuantity() != null && ingredient.getQuantity().getAmount() != null);
            }
        });
        filter(recipe.getSteps(), new Predicate<Step>()
        {
            @Override
            public boolean evaluate(Step step)
            {
                return isNotBlank(step.getDirections());
            }
        });
    }

    private class DelegatingValidatorAdaptor implements Validator
    {
        private Validator validator;

        public DelegatingValidatorAdaptor(Validator validator) { this.validator = validator; }

        @Override
        public boolean supports(Class<?> clazz)
        {
            return validator.supports(clazz);
        }

        @Override
        public void validate(Object target, Errors errors)
        {
            if (target instanceof Recipe) removeEmpties((Recipe) target);

            validator.validate(target, errors);
        }
    }
}
