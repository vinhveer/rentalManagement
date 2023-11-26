package com.vinhveer.rentalmanagement.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String gender;

    private String citizenId;

    private String address;

    private String phoneNumber;

    private String email;

    private String password;
}
