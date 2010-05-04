package xian.recipes.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Quantity
{
    @NotNull
    @Min(0)
    private BigDecimal amount;

    @NotNull
    private Unit units;

    public Quantity() { }

    public Quantity(BigDecimal amount, Unit units)
    {
        this.amount = amount;
        this.units = units;
    }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Unit getUnits() { return units; }

    public void setUnits(Unit units) { this.units = units; }

    // Instantiation helpers

    public static Quantity newQuantity(BigDecimal amount, Unit units)
    {
        return new Quantity(amount, units);
    }

    public static Quantity newQuantity(double amount, Unit units)
    {
        return new Quantity(BigDecimal.valueOf(amount), units);
    }

    public static Quantity newQuantity(String amount, Unit units)
    {
        return new Quantity(new BigDecimal(amount), units);
    }
}
