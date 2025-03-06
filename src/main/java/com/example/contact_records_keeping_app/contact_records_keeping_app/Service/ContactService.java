package com.example.contact_records_keeping_app.contact_records_keeping_app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Contacts;
import com.example.contact_records_keeping_app.contact_records_keeping_app.Repository.ContactRepository;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public int addContact(Contacts contacts) {
        return contactRepository.addContact(contacts);
    }

    public List<Contacts> getContacts(String user_id) {
        return contactRepository.getContacts(user_id);
    }

    public int updateContact(Contacts contacts){
        return contactRepository.updateContact(contacts);
    }

    public int deleteContact(String id){
        return contactRepository.deleteContact(id);
    }

}
