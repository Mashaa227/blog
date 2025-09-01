package com.blog.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    private Long id;

    @NotEmpty(message = "First name cannot be empty")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty" )
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
