package com.openclassrooms.paymybuddy.fo;

public class AuthRequestFO {
    private String username;
    private String password;

    public AuthRequestFO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthRequestFO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

