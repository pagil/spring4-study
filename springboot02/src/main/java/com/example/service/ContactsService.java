package com.example.service;

import com.example.entity.Contact;
import com.example.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactsService {

    @Autowired
    private ContactsRepository contactsRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Contact> getAll() {
        return contactsRepository.findAll();
    }
}
