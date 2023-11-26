package com.vinhveer.rentalmanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String dateOfBirth;

    @Column
    private String gender;

    @Column
    private String citizenId;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<UserRole> userRoles;
}
