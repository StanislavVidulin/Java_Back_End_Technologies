package de.ait.service.cache;

import java.math.BigDecimal;

public interface RateCache {
    CachedRate getRate(String from, String to);
    void setRate(String from, String to, BigDecimal rate);
}
