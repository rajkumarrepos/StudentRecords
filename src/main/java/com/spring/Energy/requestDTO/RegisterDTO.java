package com.spring.Energy.requestDTO;

import com.spring.Energy.conversion.Conversion;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class RegisterDTO {


    private Long studentRollNo;

    private String studentName;

    private Integer studentStd;

    private Long mobileNo;

    private MarkAddDTO markAddDTO;




}
