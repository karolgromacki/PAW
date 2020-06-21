package com.example.backend.util.model;

import java.io.Serializable;

/*
    @author Kacper Buczak 
*/
public class JwtTokenResponse implements Serializable {

    private static final long serialVersionUID = -8907219043821382190L;

    private final String jwtToken;

    public JwtTokenResponse(String jwttoken) {
        this.jwtToken = jwttoken;
    }

    public String getToken() {
        return this.jwtToken;
    }
}
