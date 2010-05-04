package xian.recipes.web.formatters;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import xian.recipes.model.Quantity;
import xian.recipes.model.Unit;

public class CustomFormattingConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean
{
    @Override
    protected void installFormatters(FormatterRegistry registry)
    {
        super.installFormatters(registry);

        registry.addFormatterForFieldType(Quantity.class, new QuantityFormatter());
        registry.addFormatterForFieldType(Unit.class, new UnitFormatter());
    }
}
