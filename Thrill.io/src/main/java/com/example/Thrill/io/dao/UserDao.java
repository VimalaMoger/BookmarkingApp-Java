package com.example.Thrill.io.dao;

import com.example.Thrill.io.dataStore.DataFromFile;
import com.example.Thrill.io.entities.User;

import java.util.List;

public class UserDao {
    public List<User> getUsers() {
        return DataFromFile.getUsers();
    }
}
