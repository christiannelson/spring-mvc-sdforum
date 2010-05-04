package xian.recipes;

import xian.recipes.model.Recipe;

import java.util.List;

public interface RecipeRepository
{
    Recipe find(long id);

    List<Recipe> find();

    void save(Recipe recipe);

    void merge(Recipe recipe);

    void update(Recipe recipe);

    void destroy(Recipe recipe);
}
