package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.ContactInformation;
import java.util.List;

public interface ContactInformationService {
    List<ContactInformation> getAllContactInfo();
    ContactInformation getContactInfoById(Long id);
    ContactInformation createContactInfo(ContactInformation contactInformation);
    ContactInformation updateContactInfo(Long id, ContactInformation contactDetails);
    void deleteContactInfo(Long id);
}
