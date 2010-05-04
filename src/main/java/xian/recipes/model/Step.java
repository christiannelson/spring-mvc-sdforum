package xian.recipes.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Step
{
    private Long id;

    @NotEmpty
    @Length(min = 1, max = 128)
    private String directions;

    public Step() {}

    public static Step newStep(String directions)
    {
        return new Step(directions);
    }

    public Step(String directions)
    {
        this.directions = directions;
    }

    public Long getId()
    {
        return id;
    }

    public String getDirections()
    {
        return directions;
    }

    public void setDirections(String directions)
    {
        this.directions = directions;
    }
}
