package com.pfe.BabySitterPFE.auth;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@Builder


public class RegistrationParentRequest {
    @NotNull
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

    private Integer childNB;

    private Integer childAge;
    @NotEmpty(message = "specific needs is mandatory ")
    @NotBlank(message = "specific needs is mandatory ")
    private String specific_needs;
    @NotEmpty(message = "Address is mandatory ")
    @NotBlank(message = "Address is mandatory ")
    private String  address;
    /*@NotEmpty(message = "Password is mandatory ")
    @NotBlank(message = "Password is mandatory ")
    private String location;*/

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChildNB(Integer childNB) {
        this.childNB = childNB;
    }

    public void setChildAge(Integer childAge) {
        this.childAge = childAge;
    }

    public void setSpecific_needs(String specific_needs) {
        this.specific_needs = specific_needs;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

