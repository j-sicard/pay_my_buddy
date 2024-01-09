package com.openclassrooms.paymybuddy.fo;

public class RegisterUserFO {
    private String email;

    private String password;

    public RegisterUserFO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegisterUserFO() {
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
