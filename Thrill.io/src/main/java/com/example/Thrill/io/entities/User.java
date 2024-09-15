package com.example.Thrill.io.entities;

import com.example.Thrill.io.constants.Gender;
import lombok.Data;
import java.util.Date;

@Data
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

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
                + ", lastName=" + lastName + ", gender=" + gender + ", userType=" + userType + "]";
    }
}
