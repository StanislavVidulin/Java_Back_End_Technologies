package de.ait.userapi.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProductResponseDto {
    private Long id;
    private String title;
    private BigDecimal price;
}
