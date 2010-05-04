package xian.recipes.web.formatters;

import org.springframework.format.Formatter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import xian.recipes.model.Quantity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;

import static com.google.common.collect.Maps.newHashMap;

public class QuantityFormatter implements Formatter<Quantity>
{
    private final static HashMap<BigDecimal, String> fractions = newHashMap();

    static
    {
        fractions.put(new BigDecimal(".25"), "1/4");
        fractions.put(new BigDecimal(".3"), "1/3");
        fractions.put(new BigDecimal(".33"), "1/3");
        fractions.put(new BigDecimal(".5"), "1/2");
        fractions.put(new BigDecimal(".6"), "2/3");
        fractions.put(new BigDecimal(".66"), "2/3");
        fractions.put(new BigDecimal(".75"), "3/4");
    }

    @Override
    public String print(Quantity quantity, Locale locale)
    {
        if (quantity.getAmount() == null) return "";

        StringBuilder sb = new StringBuilder();

        if (fractions.containsKey(quantity.getAmount().stripTrailingZeros()))
        {
            sb.append(fractions.get(quantity.getAmount().stripTrailingZeros()));
        }
        else
        {
            int a = quantity.getAmount().toString().indexOf(".") + 1;
            int b = quantity.getAmount().toString().indexOf("0", a);
            sb.append(String.format("%." + (b - a) + "f", quantity.getAmount()));
        }

        sb.append(" ");
        sb.append(quantity.getUnits().toString().toLowerCase(locale));
        return sb.toString();
    }

    @Override
    public Quantity parse(String text, Locale locale) throws ParseException
    {
        throw new NotImplementedException();
    }
}
