package com.example.lab_4;

import java.util.List;

public class PasswordStrategy implements Strategy{
    @Override
    public boolean authenticated(String login, String password, List<User> users) {
        for(User user: users){
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) return true;
        }
        return false;
    }
}
