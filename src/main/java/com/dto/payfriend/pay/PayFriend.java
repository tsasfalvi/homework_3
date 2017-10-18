package com.dto.payfriend.pay;

public class PayFriend {
    private String email;
    private String name;
    // TODO - would be nice to remove it and handle it in a separate dto
    private String userId;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
