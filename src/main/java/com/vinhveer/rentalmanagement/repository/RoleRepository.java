package com.vinhveer.rentalmanagement.repository;

import com.vinhveer.rentalmanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    boolean existsByRoleName(String roleName);
}
