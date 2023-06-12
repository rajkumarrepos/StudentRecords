package com.spring.Energy.services;

import com.spring.Energy.entity.Address;
import com.spring.Energy.requestDTO.AddressRegDTO;

public interface AddressService {
    Address addAddress(AddressRegDTO addressRegDTO);
}
