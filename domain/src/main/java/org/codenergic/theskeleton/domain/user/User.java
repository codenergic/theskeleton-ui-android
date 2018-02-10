package org.codenergic.theskeleton.domain.user;

public class User {

    private String email;

    private String password;

    private String phoneNumber;

    private String pictureUrl;

    private String username;

    public User() {
    }

    public User(String username, String password, String email, String phoneNumber,
        String pictureUrl) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pictureUrl = pictureUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }
}
