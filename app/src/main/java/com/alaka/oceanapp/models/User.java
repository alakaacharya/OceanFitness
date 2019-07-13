package com.alaka.oceanapp.models;

public class User {
    private  String uname;
    private  String username;
    private  String email;
    private  String password;


    public User(String name, String username, String email, String password) {
        this.uname = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return uname;
    }

    public void setName(String name) {
        this.uname = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

