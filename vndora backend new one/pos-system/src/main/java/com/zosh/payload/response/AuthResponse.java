package com.zosh.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zosh.payload.dto.UserDTO;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthResponse {

    private String jwt;
    private String message;
    private String title;
    private UserDTO user;


    // No-argument constructor
    public AuthResponse() {
    }


    // All-arguments constructor
    public AuthResponse(String jwt,
                        String message,
                        String title,
                        UserDTO user) {
        this.jwt = jwt;
        this.message = message;
        this.title = title;
        this.user = user;
    }


    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}