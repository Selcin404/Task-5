package com.selcin.springboot_crud.controller;

import com.selcin.springboot_crud.model.ContactInformation;
import com.selcin.springboot_crud.service.ContactInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-info")
public class ContactInformationController {
    private final ContactInformationService contactInformationService;

    public ContactInformationController(ContactInformationService contactInformationService) {
        this.contactInformationService = contactInformationService;
    }

    @GetMapping
    public List<ContactInformation> getAllContactInfo() {
        return contactInformationService.getAllContactInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactInformation> getContactInfoById(@PathVariable Long id) {
        ContactInformation contactInfo = contactInformationService.getContactInfoById(id);
        return contactInfo != null ? ResponseEntity.ok(contactInfo) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ContactInformation createContactInfo(@RequestBody ContactInformation contactInformation) {
        return contactInformationService.createContactInfo(contactInformation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactInformation> updateContactInfo(@PathVariable Long id, @RequestBody ContactInformation contactDetails) {
        ContactInformation updatedContact = contactInformationService.updateContactInfo(id, contactDetails);
        return updatedContact != null ? ResponseEntity.ok(updatedContact) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactInfo(@PathVariable Long id) {
        contactInformationService.deleteContactInfo(id);
        return ResponseEntity.noContent().build();
    }
}
