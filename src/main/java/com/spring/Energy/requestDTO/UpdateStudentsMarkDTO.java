package com.spring.Energy.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateStudentsMarkDTO {

    private Integer tamil;

    private Integer english;

    private Integer maths;

    private Integer science;

    private Integer social;
}
