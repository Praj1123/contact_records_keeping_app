package com.example.contact_records_keeping_app.contact_records_keeping_app.Controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Contacts;
import com.example.contact_records_keeping_app.contact_records_keeping_app.Service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContacte(@RequestBody Contacts contacts) {
        try {
            int result = contactService.addContact(contacts);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else if (result == -1) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getContacts")
    public ResponseEntity<List<Contacts>> gettContactes(@RequestBody Map<String, String> request) {
        try {
            String user_id = request.get("user_id");
            List<Contacts> contacts = contactService.getContacts(user_id);
            if (contacts.size() != 0) {
                return ResponseEntity.ok(contacts);
            } else if (contacts.size() == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/updateContact")
    public ResponseEntity<String> updateContact(@RequestBody Contacts contacts) {
        try {
            int result = contactService.updateContact(contacts);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else if (result == 0) {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/deleteContact")
    public ResponseEntity<String> deleteRecord(@RequestBody Map<String, String> request) {
        try {
            String id = request.get("id");
            int result = contactService.deleteContact(id);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else if (result == 0) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
