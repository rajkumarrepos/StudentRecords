package com.spring.Energy.requestDTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class MarkAddDTO {

    private Long studentRollNo;

    private Integer tamil;

    private Integer english;

    private Integer maths;

    private Integer science;

    private Integer social;


}
