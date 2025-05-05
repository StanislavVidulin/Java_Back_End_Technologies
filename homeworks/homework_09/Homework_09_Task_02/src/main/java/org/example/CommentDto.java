package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class CommentDto {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
