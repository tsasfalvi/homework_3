package com.epam.dto.payfriend.getuser.request;

public class GetUserRequest {
    private String email;

    public GetUserRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
