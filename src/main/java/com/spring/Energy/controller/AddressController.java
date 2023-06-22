package com.spring.Energy.controller;

import com.spring.Energy.entity.Address;
import com.spring.Energy.requestDTO.AddressRegDTO;
import com.spring.Energy.services.AddressService;
import com.spring.Energy.services.MarkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/students/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
@PostMapping(value = "/register")
  public Address addressHandler (@RequestBody AddressRegDTO addressRegDTO){
      Address addedObject = addressService.addAddress(addressRegDTO);
      return addedObject;

    }

}
