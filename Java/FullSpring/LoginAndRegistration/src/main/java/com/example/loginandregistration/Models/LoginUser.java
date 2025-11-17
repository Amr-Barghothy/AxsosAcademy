package com.example.loginandregistration.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUser {
    @NotBlank(message = "Email is required")
    @Email(message = "Email is invalid")
    private String loginEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 8 , message = "Password should be at least 8 characters")
    private String loginPassword;

    public LoginUser() {
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email is invalid") String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(@NotBlank(message = "Email is required") @Email(message = "Email is invalid") String loginEmail) {
        this.loginEmail = loginEmail;
    }

    public @NotBlank(message = "Password is required") @Size(min = 8, message = "Password should be at least 8 characters") String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(@NotBlank(message = "Password is required") @Size(min = 8, message = "Password should be at least 8 characters") String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
