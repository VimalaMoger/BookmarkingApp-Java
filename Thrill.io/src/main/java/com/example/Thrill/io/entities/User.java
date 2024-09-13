package com.example.Thrill.io.entities;

import com.example.Thrill.io.constants.Gender;

import java.util.Date;

public class User {
    private  long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String userType;
    private Date created_date;
    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstNsme(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + ", gender=" + gender + ", userType=" + userType + "]";
    }
}
