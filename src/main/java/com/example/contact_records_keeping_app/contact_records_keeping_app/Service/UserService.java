package com.example.contact_records_keeping_app.contact_records_keeping_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Users;
import com.example.contact_records_keeping_app.contact_records_keeping_app.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int addUser(Users users) {
        System.out.println("Request send from service");
        return userRepository.addUser(users);
    }

    public Users getUser(String email) {
        return userRepository.getUser(email);
    }

    public int updaUsers(Users users) {
        return userRepository.updateUser(users);
    }

    public int deleteUser(String id) {
        return userRepository.deleteUser(id);
    }
}
