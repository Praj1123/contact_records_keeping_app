package com.example.contact_records_keeping_app.contact_records_keeping_app.Entity;

public class Contacts {
    private String id;
    private String user_id;
    private String name;
    private String position;
    private String phone;
    private String email;
    private String address;

    public Contacts() {
    }
    

    public Contacts(String id, String user_id, String name, String position, String phone, String email,
            String address) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

}
