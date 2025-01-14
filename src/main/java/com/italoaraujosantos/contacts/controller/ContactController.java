package com.italoaraujosantos.contacts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoaraujosantos.contacts.models.ContactModel;
import com.italoaraujosantos.contacts.service.ContactService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("")
    public List<ContactModel> contacts() {
        return contactService.listAll();
    }
  
    @PostMapping("")
    public ContactModel createContact(@RequestBody ContactModel contactModel) {
        var result = contactService.create(contactModel);
        return result;
    }

    //http://localhost:8080/contact/email
    @GetMapping("/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable("email") String email) {
        var result = contactService.findByEmail(email);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        return ResponseEntity.status(400).body("Contato não localizado!");
    }
}
