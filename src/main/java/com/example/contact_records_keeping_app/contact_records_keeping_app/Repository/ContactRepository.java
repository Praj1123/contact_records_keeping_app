package com.example.contact_records_keeping_app.contact_records_keeping_app.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Contacts;

@Repository
public class ContactRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Contacts> contactRowMapper = (rs, rowNum) -> {
        Contacts contacts = new Contacts();
        contacts.setId(rs.getString("id"));
        contacts.setUser_id(rs.getString("user_id"));
        contacts.setName(rs.getString("name"));
        contacts.setPosition(rs.getString("position"));
        contacts.setPhone(rs.getString("phone"));
        contacts.setEmail(rs.getString("email"));
        contacts.setAddress(rs.getString("address"));
        return contacts;
    };

    public int addContact(Contacts contacts) {
        try {
            String sql = "INSERT INTO contacts (id, user_id, name, position, phone, email, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
            int result = jdbcTemplate.update(sql, contacts.getId(), contacts.getUser_id(), contacts.getName(),
                    contacts.getPosition(), contacts.getPhone(), contacts.getEmail(), contacts.getAddress());
            System.out.println("Contact added");
            return result;
        } catch (DuplicateKeyException e) {
            System.out.println("Contact already exists");
            return -1;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return 0;
        }
    }

    public List<Contacts> getContacts(String user_id) {
        try {
            String sql = "SELECT * FROM contacts WHERE user_id = ?";
            return jdbcTemplate.query(sql, contactRowMapper, user_id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("No contacts found");
            return null;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        }

    }

    public int updateContact(Contacts contacts) {
        try {
            String sql = "UPDATE contacts SET name = ?, position = ?, phone = ?, email = ?, address = ? WHERE id = ?";
            int result = jdbcTemplate.update(sql, contacts.getName(), contacts.getPosition(), contacts.getPhone(),
                    contacts.getEmail(), contacts.getAddress(), contacts.getId());
            return result;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public int deleteContact(String id) {
        try {
            String sql = "DELETE FROM contacts WHERE id = ?";
            int result = jdbcTemplate.update(sql, id);
            return result;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

}
