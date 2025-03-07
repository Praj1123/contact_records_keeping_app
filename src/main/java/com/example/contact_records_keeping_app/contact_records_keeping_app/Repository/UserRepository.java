package com.example.contact_records_keeping_app.contact_records_keeping_app.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import com.example.contact_records_keeping_app.contact_records_keeping_app.Entity.Users;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Users> userRowMapper = (rs, rowNum) -> {
        Users user = new Users();
        user.setId(rs.getString("id"));
        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setPhone(rs.getString("phone"));
        user.setUser_password(rs.getString("user_password"));
        return user;
    };

    public int addUser(Users users) {
        try {
            String sql = "INSERT INTO users (id, email, name, phone, user_password) VALUES (?, ?, ?, ?, ?)";
            int result = jdbcTemplate.update(sql, users.getId(), users.getEmail(), users.getName(), users.getPhone(),
                    users.getUser_password());
            System.out.println("User added");
            return result;
        } catch (DuplicateKeyException e) {
            System.out.println("User already exists");
            return -1;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return 0;
        }
    }

    public Users getUser(String email) {
        try {
            String sql = "SELECT * FROM users WHERE email = ?";
            return jdbcTemplate.queryForObject(sql, userRowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("User not found");
            return null;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return null;
        }
    }

    public int updateUser(Users users) {
        try {
            String sql = "UPDATE users SET name = ?, phone = ?, user_password = ? WHERE email = ?";
            int result = jdbcTemplate.update(sql, users.getName(), users.getPhone(), users.getUser_password(),
                    users.getEmail());
            return result;
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            return 0;
        }
    }

    public int deleteUser(String id) {
        try {
            String sql = "DELETE FROM users WHERE id = ?";
            int result = jdbcTemplate.update(sql, id);
            return result;
        } catch (Exception e) {
            System.out.println("Error occured " + e);
            return -1;
        }
    }

}
