package com.vinhveer.rentalmanagement.repository;

import com.vinhveer.rentalmanagement.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
