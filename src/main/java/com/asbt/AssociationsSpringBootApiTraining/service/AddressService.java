package com.asbt.AssociationsSpringBootApiTraining.service;

import com.asbt.AssociationsSpringBootApiTraining.exceptions.AddressNotFoundException;
import com.asbt.AssociationsSpringBootApiTraining.model.Address;
import com.asbt.AssociationsSpringBootApiTraining.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }
    public Address getAddressById(Long addressId){
        return addressRepository.getAddressById(addressId).orElseThrow(()-> new AddressNotFoundException("Address not found"));
    }
    public List<Address> getAllAddresss(){
        List<Address> addressList = addressRepository.findAll();
        return addressList;
    }
    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }
    public void deleteAddressById(Long addressId){
        addressRepository.deleteById(addressId);
    }

}
