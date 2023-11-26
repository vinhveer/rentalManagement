package com.vinhveer.rentalmanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long role_id;

    @Column
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<UserRole> userRoles;
}
