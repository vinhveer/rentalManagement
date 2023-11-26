package com.vinhveer.rentalmanagement.service.Implement;

import com.vinhveer.rentalmanagement.model.Role;
import com.vinhveer.rentalmanagement.model.User;
import com.vinhveer.rentalmanagement.model.UserRole;
import com.vinhveer.rentalmanagement.payload.request.UserRequest;
import com.vinhveer.rentalmanagement.payload.response.ListDataResponse;
import com.vinhveer.rentalmanagement.repository.UserRepository;
import com.vinhveer.rentalmanagement.repository.UserRoleRepository;
import com.vinhveer.rentalmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    private boolean userExists(UserRequest userRequest) {
        return userRepository.existsByEmail(userRequest.getEmail());
    }

    @Override
    public ResponseEntity<Object> GetAll() {
        try {
            List<User> users = userRepository.findAll();
            ListDataResponse<Object> listDataResponse = ListDataResponse.builder().message("OK").data(users).build();
            return ResponseEntity.ok(listDataResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> Add(UserRequest userRequest) {
        try {
            if (userExists(userRequest)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
            }

            User user = new User();
            user.setFirstName(userRequest.getFirstName());
            user.setLastName(userRequest.getLastName());
            user.setDateOfBirth(userRequest.getDateOfBirth());
            user.setGender(userRequest.getGender());
            user.setCitizenId(userRequest.getCitizenId());
            user.setAddress(userRequest.getAddress());
            user.setPhoneNumber(userRequest.getPhoneNumber());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());

            userRepository.save(user);

            Role role = userRequest.getRole();

            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            userRoleRepository.save(userRole);

            return ResponseEntity.status(HttpStatus.CREATED).body("User added successfully with roles!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception: " + e.getMessage());
        }
    }


    @Override
    public ResponseEntity<Object> GetByID(long id) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();
                return ResponseEntity.ok(existingUser);
            } else {
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder().message("User not found!").build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listDataResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from the server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> DeleteByID(long id) {
        try {
            if (userRepository.existsById(id)) {
                userRepository.deleteById(id);
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                        .message("User " + id + " deleted " + "successfully").build();
                return ResponseEntity.ok(listDataResponse);
            } else {
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                        .message("Category not found").build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listDataResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception = " + e);
        }

    }

    @Override
    public ResponseEntity<Object> EditByID(UserRequest userRequest, long id) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
                User existingUser = userOptional.get();

                if (!userRequest.getFirstName().isBlank()) {
                    existingUser.setFirstName(userRequest.getFirstName());
                }

                if (!userRequest.getLastName().isBlank()) {
                    existingUser.setLastName(userRequest.getLastName());
                }

                if (!userRequest.getDateOfBirth().isBlank()) {
                    existingUser.setDateOfBirth(userRequest.getDateOfBirth());
                }

                if (!userRequest.getGender().isBlank()) {
                    existingUser.setGender(userRequest.getGender());
                }

                if (!userRequest.getCitizenId().isBlank()) {
                    existingUser.setCitizenId(userRequest.getCitizenId());
                }

                if (!userRequest.getAddress().isBlank()) {
                    existingUser.setAddress(userRequest.getAddress());
                }

                if (!userRequest.getPhoneNumber().isBlank()) {
                    existingUser.setPhoneNumber(userRequest.getPhoneNumber());
                }

                if (!userRequest.getEmail().isBlank()) {
                    existingUser.setEmail(userRequest.getEmail());
                }

                if (!userRequest.getPassword().isBlank()) {
                    existingUser.setPassword(userRequest.getPassword());
                }

                userRepository.save(existingUser);

                return ResponseEntity.ok("User updated successfully!");
            } else {
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder().message("User not found!").build();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listDataResponse);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from the server with exception = " + e);
        }
    }
}
