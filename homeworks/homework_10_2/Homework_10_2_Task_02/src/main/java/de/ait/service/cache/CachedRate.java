package de.ait.service.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CachedRate {
    private final String from;
    private final String to;
    private final BigDecimal rate;
    private final LocalDateTime timeStamp = LocalDateTime.now();
}
