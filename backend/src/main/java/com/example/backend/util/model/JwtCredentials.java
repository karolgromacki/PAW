package com.example.backend.util.model;

import java.io.Serializable;

/*
    @author Karol Gromacki 
*/
public class JwtCredentials implements Serializable {

    private static final long serialVersionUID = 3287529837082134098L;

    private String username;

    private String password;

    public JwtCredentials() {
    }

    public JwtCredentials(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
