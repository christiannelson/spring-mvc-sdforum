package xian.recipes.model;

import org.junit.Test;

import java.math.BigDecimal;

import static xian.recipes.model.Ingredient.newIngredient;
import static xian.recipes.model.Quantity.newQuantity;
import static xian.recipes.model.Step.newStep;

public class RecipeTest
{
    @Test
    public void shouldCreateRecipeWithIngredientsAndSteps()
    {
        Recipe recipe = new Recipe();
        recipe.setName("Aloo Ghobi (Potatos and Cauliflower)");
        recipe.setDescription("");
        recipe.setCost(BigDecimal.valueOf(9.00));
        recipe.setPreparationTime(45);
        recipe.addIngredient(newIngredient("Vegetable Oil", newQuantity(0.25, Unit.CUP)));
        recipe.addIngredient(newIngredient("Large Onion", newQuantity(1, Unit.WHOLE), "peeled and cut into small pieces"));
        recipe.addIngredient(newIngredient("Fresh Coriander", newQuantity(1, Unit.BUNCH), "separated into stalks and leaves and roughly chopped"));
        recipe.addIngredient(newIngredient("Small Green Chili", newQuantity(1, Unit.WHOLE), "chopped into small pieces"));
        recipe.addIngredient(newIngredient("Large Cauliflower", newQuantity(1, Unit.WHOLE), "eaves removed and cut evenly into eighths"));
        recipe.addIngredient(newIngredient("Large Potatoes", newQuantity(3, Unit.WHOLE), "peeled and cut into even pieces"));
        recipe.addIngredient(newIngredient("Diced Tomoatoes", newQuantity(2, Unit.CANS), ""));
        recipe.addIngredient(newIngredient("Fresh Ginger", newQuantity(2, Unit.TABLESPOON), "peeled and grated"));
        recipe.addIngredient(newIngredient("Fresh Garlic", newQuantity(1, Unit.TEASPOON), "chopped"));
        recipe.addIngredient(newIngredient("Cumin Seed", newQuantity(1, Unit.TEASPOON), ""));
        recipe.addIngredient(newIngredient("Tumeric", newQuantity(2, Unit.TEASPOON), ""));
        recipe.addIngredient(newIngredient("Salt", newQuantity(1, Unit.TEASPOON), ""));
        recipe.addIngredient(newIngredient("Garam Masala", newQuantity(2, Unit.TEASPOON), ""));
        recipe.addStep(newStep("Heat vegetable oil in a large saucepan."));
        recipe.addStep(newStep("Add the chopped onion and one teaspoon of cumin seeds to the oil."));
        recipe.addStep(newStep("Stir together and cook until onions become creamy, golden, and translucent."));
        recipe.addStep(newStep("Add chopped coriander stalks, two teaspoons of turmeric, and one teaspoon of salt."));
        recipe.addStep(newStep("Add chopped chillis (according to taste) Stir tomatoes into onion mixture."));
        recipe.addStep(newStep("Add ginger and garlic; mix thoroughly."));
        recipe.addStep(newStep("Add potatoes and cauliflower to the sauce plus a few tablespoons of water (ensuring that the mixture doesn't stick to the saucepan)."));
        recipe.addStep(newStep("Ensure that the potatoes and cauliflower are coated with the curry sauce."));
        recipe.addStep(newStep("Cover and allow to simmer for twenty minutes (or until potatoes are cooked)."));
        recipe.addStep(newStep("Add two teaspoons of Garam Masala and stir."));
        recipe.addStep(newStep("Sprinkle chopped coriander leaves on top of the curry."));
        recipe.addStep(newStep("Turn off the heat, cover, and leave for as long as possible before serving."));
    }
}
