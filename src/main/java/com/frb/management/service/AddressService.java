package com.frb.management.service;

import com.frb.management.model.Address;
import com.frb.management.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAll(List<Address> addressList){
        addressRepository.saveAll(addressList);
    }
}
