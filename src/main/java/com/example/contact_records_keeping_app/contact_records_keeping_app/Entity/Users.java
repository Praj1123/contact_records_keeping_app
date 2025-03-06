package com.example.contact_records_keeping_app.contact_records_keeping_app.Entity;

public class Users {
    private String id;
    private String email;
    private String name;
    private String phone;
    private String user_password;

    public Users() {
    }
    
    public Users(String id, String email, String name, String phone, String user_password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.user_password = user_password;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    

}
