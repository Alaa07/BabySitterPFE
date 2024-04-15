package com.pfe.BabySitterPFE.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationBabySitterRequest {

    @NotEmpty(message = "Firstname is mandatory ")
    @NotBlank(message = "Firstname is mandatory ")
    private String firstName;
    @NotEmpty(message = "Lastname is mandatory ")
    @NotBlank(message = "Lastname is mandatory ")
    private String lastName;
    @NotEmpty(message = "Email is mandatory ")
    @NotBlank(message = "Email is mandatory ")
    @Email(message = "Email is not well formatted ")
    private String email;
    @NotEmpty(message = "Password is mandatory ")
    @NotBlank(message = "Password is mandatory ")
    @Size(min = 8, message = "size should be 8 characters long minimum")
    private String password;
    @NotEmpty(message = "Availability is mandatory ")
    @NotBlank(message = "Availability is mandatory ")
    private String availability;
    @NotEmpty(message = "Hourly Rate is mandatory ")
    @NotBlank(message = "Hourly Rate is mandatory ")
    private String hourlyRate;
    @NotEmpty(message = "Experience is mandatory ")
    @NotBlank(message = "Experience is mandatory ")
    private String experience;
    @NotEmpty(message = "Competence is mandatory ")
    @NotBlank(message = "Competence is mandatory ")
    private String competence;
    @NotEmpty(message = "Description is mandatory ")
    @NotBlank(message = "Description is mandatory ")
    private String description;
    @NotEmpty(message = "Photo is mandatory ")
    @NotBlank(message = "Photo is mandatory ")
    private String photo;
}

