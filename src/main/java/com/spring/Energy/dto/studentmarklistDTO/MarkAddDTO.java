package com.spring.Energy.dto.studentmarklistDTO;

import jakarta.validation.Constraint;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Constraint;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Range;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
public class MarkAddDTO {

    @Min(5)
    private Long studentRegId;

    @NotBlank(message = "not null")
    private String studentName;

    private Integer tamilMark;

    private Integer englishMark;

    private Integer mathsMark;

    private Integer scienceMark;
    private Integer socialMark;

}
