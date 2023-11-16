package com.example.lab_4;

import java.util.List;

public class SurnameStrategy implements Strategy{
    @Override
    public boolean authenticated(String login, String mumSurname, List<User> users) {
        for(User user: users){
            if(user.getLogin().equals(login) && user.getMumSurname().equals(mumSurname)) return true;
        }
        return false;
    }
}
