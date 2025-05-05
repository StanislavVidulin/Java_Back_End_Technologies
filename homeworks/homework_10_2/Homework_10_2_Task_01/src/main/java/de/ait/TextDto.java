package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class TextDto {
    private List<DataDto> text;
}
