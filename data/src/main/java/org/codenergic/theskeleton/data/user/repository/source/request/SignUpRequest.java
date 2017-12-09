package org.codenergic.theskeleton.data.user.repository.source.request;

public class SignUpRequest {

    private String username;

    private String password;

    private String email;

    public SignUpRequest(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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
}
