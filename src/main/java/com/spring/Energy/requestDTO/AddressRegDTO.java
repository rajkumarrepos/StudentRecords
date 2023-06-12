package com.spring.Energy.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRegDTO {

    private Long studentRollNo;

    private Integer doorNo;

    private String streetName;

    private String city;

    private String state;

    private String country;

    private Long pinCode;

}
