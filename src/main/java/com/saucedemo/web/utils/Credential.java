package com.saucedemo.web.utils;

import lombok.Getter;

@Getter
public class Credential {
    private final String baseUrl;
    private final String email;
    private final String mobile;
    private final String userName;
    private final String password;
    private final String verificationCode;
    private final String pin;

    public Credential(String baseUrl,String email, String username, String mobile, String password, String verificationCode, String pin) {
        this.baseUrl = baseUrl;
        this.email = email;
        this.mobile = mobile;
        this.userName= username;
        this.password = password;
        this.verificationCode = verificationCode;
        this.pin = pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Credential that = (Credential) o;

        if (!baseUrl.equals(that.baseUrl)) return false;
        if (!userName.equals(that.userName)) return false;
        return password.equals(that.password);
    }

    @Override
    public int hashCode() {
        int result = baseUrl.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
