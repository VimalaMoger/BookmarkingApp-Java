package com.example.Thrill.io.dao;

import com.example.Thrill.io.dataStore.DataStore;
import com.example.Thrill.io.entities.User;

public class UserDao {
    public User[] getUsers() {
        return DataStore.getUsers();
    }
}
