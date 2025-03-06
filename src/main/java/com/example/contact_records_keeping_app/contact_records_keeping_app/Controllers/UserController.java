package com.example.contact_records_keeping_app.contact_records_keeping_app.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Users;
import com.example.contact_records_keeping_app.contact_records_keeping_app.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody Users users) {
        try {
            System.out.println("Request sent from controller");
            int result = userService.addUser(users);
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

    @GetMapping("/getUser")
    public ResponseEntity<Users> getUser(@RequestBody Map<String, String> request) {
        try {
            String email = request.get("email");
            Users user = userService.getUser(email);
            if (user != null) {
                return ResponseEntity.status(HttpStatus.OK).body(user);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<Integer> updateUser(@RequestBody Users users) {
        try {
            int result = userService.updaUsers(users);
            if (result > 0) {
                return ResponseEntity.status(HttpStatus.OK).body(result);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
