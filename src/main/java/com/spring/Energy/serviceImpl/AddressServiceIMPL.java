package com.spring.Energy.serviceImpl;

import com.spring.Energy.entity.Address;
import com.spring.Energy.repository.AddressRepo;
import com.spring.Energy.requestDTO.AddressRegDTO;
import com.spring.Energy.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceIMPL implements AddressService {
    @Autowired
    private AddressRepo addressRepo;
    public Address addAddress(AddressRegDTO addressRegDTO){
        Address address = new Address();

        BeanUtils.copyProperties(addressRegDTO,address);

        addressRepo.save(address);


        return address;
    }
}
