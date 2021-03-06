package com.Prana.Latifi.jwt;


import com.google.gson.Gson;
import com.Prana.Latifi.entity.Role;
import com.Prana.Latifi.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JwtWrapper {


    private Map<String, UserWrapper> token;


    public JwtWrapper(Map<String , User> map) {

        this.token = new HashMap<>();
        for (Map.Entry<String, User> entry : map.entrySet()) {
            String username = entry.getKey();
            User user = entry.getValue();
            List<Role> roles = user.getRoles();

            UserWrapper wrapper = new UserWrapper(username, roles);
            this.token.put(wrapper.getUsername(), wrapper);
        }
    }


    public Map<String, UserWrapper> getToken() {
        return token;
    }

    public void setToken(Map<String, UserWrapper> token) {
        this.token = token;
    }

    public UserWrapper getUserWrapper(String clientKey) {
        return token.get(clientKey);
    }

    public List<UserWrapper> getUsersList() {
        return new ArrayList<>(token.values());
    }

    public String getUserJson(String clientKey) {
        return new Gson().toJson(getUserWrapper(clientKey));
    }
}

