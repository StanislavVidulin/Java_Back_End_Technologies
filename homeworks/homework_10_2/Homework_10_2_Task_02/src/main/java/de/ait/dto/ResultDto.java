package de.ait.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
public class ResultDto {
    private BigDecimal result;
    private RateDto info;
}
