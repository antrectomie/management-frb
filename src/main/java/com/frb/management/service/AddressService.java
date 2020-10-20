package com.frb.management.service;

import com.frb.management.model.Address;
import com.frb.management.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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

    public void save(Address address) {
        addressRepository.save(address);
    }

    public Address getById(Long id) {
        return addressRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Entity not found"));
    }
}
