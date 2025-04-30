package de.ait;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class ResultDto {
    // можно и через массив
//    private TagDto[] tags;
    private List<TagDto> tags;
}
