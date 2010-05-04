package xian.recipes.web.formatters;

import org.apache.commons.lang.StringUtils;
import org.springframework.format.Formatter;
import org.springframework.format.Printer;
import xian.recipes.model.Unit;

import java.text.ParseException;
import java.util.Locale;

public class UnitFormatter implements Formatter<Unit>
{
    @Override
    public String print(Unit unit, Locale locale)
    {
        return StringUtils.lowerCase(unit.toString());
    }

    @Override
    public Unit parse(String text, Locale locale) throws ParseException
    {
        return Enum.valueOf(Unit.class, text.toUpperCase().trim());
    }
}
