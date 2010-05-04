package xian.recipes.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Ingredient
{
    private Long id;

    @NotEmpty
    @Length(min = 1, max = 64)
    private String name;

    @Valid
    @NotNull
    private Quantity quantity;

    @Length(max = 200)
    private String preparation;

    public static Ingredient newIngredient(String name, Quantity quantity)
    {
        return new Ingredient(name, quantity, null);
    }

    public static Ingredient newIngredient(String name, Quantity quantity, String preparation)
    {
        return new Ingredient(name, quantity, preparation);
    }

    public Ingredient() { }

    public Ingredient(String name, Quantity quantity, String preparation)
    {
        this.name = name;
        this.quantity = quantity;
        this.preparation = preparation;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Quantity getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Quantity quantity)
    {
        this.quantity = quantity;
    }

    public String getPreparation()
    {
        return preparation;
    }

    public void setPreparation(String preparation)
    {
        this.preparation = preparation;
    }
}
