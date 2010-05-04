package xian.recipes.model;

import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

public class Recipe
{
    private Long id;

    @NotEmpty
    @Length(min = 1, max = 64)
    private String name;

    private String description;

    @NotNull
    @Range(min = 1, max = 12)
    private int servingCount = 4;

    @NotNull
    @Min(1)
    private int preparationTime = 10;

    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    @Range(min = 0)
    private BigDecimal cost;

    @Valid
    @Size(min = 1, message = "At least one ingredient is required for a recipe.")
    private List<Ingredient> ingredients = Lists.newArrayList();

    @Valid
    @Size(min = 1, message = "At least one step is required.")
    private List<Step> steps = Lists.newArrayList();

    public Recipe() {}

    public Recipe(String name) { this.name = name; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getServingCount() { return servingCount; }

    public void setServingCount(int servingCount) { this.servingCount = servingCount; }

    public int getPreparationTime() { return preparationTime; }

    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }

    public BigDecimal getCost() { return cost; }

    public void setCost(BigDecimal cost) { this.cost = cost; }

    public List<Ingredient> getIngredients() { return ingredients; }

    public void addIngredient(Ingredient ingredient) { ingredients.add(ingredient); }

    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public List<Step> getSteps() { return steps; }

    public void addStep(Step step) { steps.add(step); }

    public void setSteps(List<Step> steps) { this.steps = steps; }
}
