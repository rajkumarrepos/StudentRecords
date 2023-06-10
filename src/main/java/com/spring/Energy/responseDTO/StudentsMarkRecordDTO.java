package com.spring.Energy.responseDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class StudentsMarkRecordDTO {

    private Long studentRollNO;


    private Integer tamil;

    private Integer english;

    private Integer maths;

    private Integer science;

    private Integer social;

    private String createdDateTime;
}
