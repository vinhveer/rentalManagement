package com.vinhveer.rentalmanagement.payload.request;

import com.vinhveer.rentalmanagement.model.Role;
import lombok.Data;
import jakarta.validation.constraints.Size;

@Data
public class UserRequest {
    private long id;

    @Size(max = 255, message = "Too long!")
    private String firstName;

    @Size(max = 255, message = "Too long!")
    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String citizenId;

    private String address;

    private String phoneNumber;

    private String email;

    private String password;

    private Role role;
}