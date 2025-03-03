package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.ContactInformation;
import com.selcin.springboot_crud.repository.ContactInformationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {
    private final ContactInformationRepository contactInformationRepository;

    public ContactInformationServiceImpl(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    @Override
    public List<ContactInformation> getAllContactInfo() {
        return contactInformationRepository.findAll();
    }

    @Override
    public ContactInformation getContactInfoById(Long id) {
        return contactInformationRepository.findById(id).orElse(null);
    }

    @Override
    public ContactInformation createContactInfo(ContactInformation contactInformation) {
        return contactInformationRepository.save(contactInformation);
    }

    @Override
    public ContactInformation updateContactInfo(Long id, ContactInformation contactDetails) {
        Optional<ContactInformation> contact = contactInformationRepository.findById(id);
        if (contact.isPresent()) {
            ContactInformation updatedContact = contact.get();
            updatedContact.setPhoneNumber(contactDetails.getPhoneNumber());
            updatedContact.setAlternateEmail(contactDetails.getAlternateEmail());
            return contactInformationRepository.save(updatedContact);
        }
        return null;
    }

    @Override
    public void deleteContactInfo(Long id) {
        contactInformationRepository.deleteById(id);
    }
}
