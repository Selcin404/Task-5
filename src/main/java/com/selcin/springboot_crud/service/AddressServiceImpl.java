package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.Address;
import com.selcin.springboot_crud.repository.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address addressDetails) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            Address updatedAddress = address.get();
            updatedAddress.setStreet(addressDetails.getStreet());
            updatedAddress.setCity(addressDetails.getCity());
            return addressRepository.save(updatedAddress);
        }
        return null;
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
