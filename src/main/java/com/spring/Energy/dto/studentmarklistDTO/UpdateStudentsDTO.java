package com.spring.Energy.dto.studentmarklistDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateStudentsDTO {
    private String studentName;
    private Integer tamilMark;

    private Integer englishMark;

    private Integer mathsMark;

    private Integer scienceMark;
    private Integer socialMark;
}
