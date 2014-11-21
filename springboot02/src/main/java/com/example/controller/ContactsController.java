package com.example.controller;

import com.example.entity.Contact;
import com.example.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/contacts")
    public List<Contact> getAll() {
        return contactsService.getAll();
    }

}
