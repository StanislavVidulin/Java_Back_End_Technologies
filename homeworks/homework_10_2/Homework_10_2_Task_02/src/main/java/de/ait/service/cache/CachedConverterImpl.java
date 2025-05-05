package de.ait.service.cache;

import de.ait.model.Conversion;
import de.ait.service.Converter;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
public class CachedConverterImpl implements Converter {
    public Converter converter;
    public RateCache cache;

    /*
      1. обращаемся к кэш,
      2. если в кэш есть значение -> вычисляем результат Conversion: курс из кэша * на сумму
      3. если в кэш нет значения -> берем ConverterFixerImpl и идем в апи за данными
     */
    @Override
    public Conversion convert(String from, String to, double amount) {
        from = from.toLowerCase().trim();
        to = to.toLowerCase().trim();
        CachedRate rate = cache.getRate(from, to); // обратились к кэш
        if (rate != null) {
            Conversion conversion = new Conversion(from, to, new BigDecimal(amount));
            BigDecimal amountTo = rate.getRate()  // умножаем BigDecimal на BigDecimal: rate*amount
                    .multiply(BigDecimal.valueOf(amount)).setScale(2, RoundingMode.HALF_UP);
            conversion.setAmountTo(amountTo);
            return conversion;
        } else {
            Conversion result = converter.convert(from, to, amount);
            cache.setRate(from, to, result.getRate());
            return result;
        }

    }
}
