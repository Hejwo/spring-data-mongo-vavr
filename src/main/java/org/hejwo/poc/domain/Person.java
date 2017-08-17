package org.hejwo.poc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Person {

    private String name;
    private String nickname;
    private Integer age;

}
