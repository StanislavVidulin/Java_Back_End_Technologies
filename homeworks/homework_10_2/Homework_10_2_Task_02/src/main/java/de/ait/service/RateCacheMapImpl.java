package de.ait.service;

import de.ait.service.cache.CachedRate;
import de.ait.service.cache.RateCache;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RateCacheMapImpl implements RateCache {
    public static final int ACTUAL_TIME = 3;
    private Map<String, CachedRate> map = new HashMap<>();

    @Override
    public CachedRate getRate(String from, String to) {
        String key = from+to;  // eurusd
        CachedRate cachedRate = map.get(key);
        if (cachedRate!=null && isActual(cachedRate)){
            return  cachedRate;
        }
        return null;
    }



    private boolean isActual(CachedRate cachedRate) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime timeStamp = cachedRate.getTimeStamp();
        return Duration.between(timeStamp,now).toMinutes()<= ACTUAL_TIME;
    }

    @Override
    public void setRate(String from, String to, BigDecimal rate) {
        String key = from+to;
        map.put(key, new CachedRate(from,to,rate));
    }
}
