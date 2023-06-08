package com.spring.Energy.dto.studentmarklistDTO;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StudentsRecordDTO {
    private Long studentRegId;
    private String studentName;
    private Integer tamilMark;

    private Integer englishMark;

    private Integer mathsMark;

    private Integer scienceMark;
    private Integer socialMark;
    private String createdDateTime;
}
