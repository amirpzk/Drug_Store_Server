package com.Prana.Latifi.request;

public class ProfileRequest {

    private String avatar;
    private String firstName;
    private String lastName;

    public ProfileRequest(String avatar, String firstName, String lastName) {
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
