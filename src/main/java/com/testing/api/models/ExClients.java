package com.testing.api.models;

public class ExClients {

    private String name;
    private String lastName;
    private String country;
    private String city;
    private String email;
    private String phone;
    private String id;
    
    public ExClients(String name, String lastName, String country, String city,String email,String phone, String id) {
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
