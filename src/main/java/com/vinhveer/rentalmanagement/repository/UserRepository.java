package com.vinhveer.rentalmanagement.repository;

import com.vinhveer.rentalmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    boolean existsByFirstName(String firstName);
//    boolean existsByLastName(String lastName);
//    boolean existsByDateOfBirth(String dateOfBirth);
//    boolean existsByGender(String gender);
//
//    boolean existsByCitizenId(String citizenId);
//
//    boolean existsByAddress(String address);
//
//    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

//    boolean existsByPassword(String password);
}