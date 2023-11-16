package com.example.lab_4;

import java.util.List;

public interface Strategy {
    boolean authenticated(String login, String password, List<User> users);
}
