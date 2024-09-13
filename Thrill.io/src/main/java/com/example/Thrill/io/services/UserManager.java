package com.example.Thrill.io.services;

import com.example.Thrill.io.constants.Gender;
import com.example.Thrill.io.dao.UserDao;
import com.example.Thrill.io.entities.User;

public class UserManager {
    //using Singleton pattern
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();

    private UserManager() {}

    public static UserManager getInstance(){
        return instance;
    }

    public User createUser(long id, String email, String password, String firstName, String lastName, Gender gender, String userType) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstNsme(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);
        return user;
    }

    public User[] getUsers() {
        return dao.getUsers();
    }
}

