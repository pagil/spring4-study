package com.example.controller;

import com.example.entity.Contact;
import com.example.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Use @RestController instead of @Controller to avoid exception:
// javax.servlet.ServletException: Circular view path []: would dispatch to the current handler URL [/] again. Check your View...
@RestController
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/contacts")
    public List<Contact> getAll() {
        return contactsService.getAll();
    }

}
