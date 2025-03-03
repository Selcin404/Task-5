package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.Address;
import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Long id, Address addressDetails);
    void deleteAddress(Long id);
}
