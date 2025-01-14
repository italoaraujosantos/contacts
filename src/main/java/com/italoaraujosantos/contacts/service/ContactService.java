package com.italoaraujosantos.contacts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.italoaraujosantos.contacts.models.ContactModel;

@Service
public class ContactService {
    List<ContactModel> contacts = new ArrayList<>();

    public ContactModel create(ContactModel contactModel) {
        contactModel.setId(UUID.randomUUID());
        contacts.add(contactModel);
        return contactModel;
    }

    public List<ContactModel> listAll(){
        return contacts;
    }

    public Optional<ContactModel> findByEmail(String email) {
        var contact = this.contacts.stream().filter(c->c.getEmail().equals(email)).findFirst();
        return contact;
    } 
}
