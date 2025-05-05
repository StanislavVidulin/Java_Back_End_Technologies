package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@NoArgsConstructor
@ToString
public class TextDto {
    private Map<String, Integer> coordinates;
    private String data;
}
