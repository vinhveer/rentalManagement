package com.vinhveer.rentalmanagement.service.Implement;

import com.vinhveer.rentalmanagement.model.Role;
import com.vinhveer.rentalmanagement.payload.request.RoleRequest;
import com.vinhveer.rentalmanagement.payload.response.ListDataResponse;
import com.vinhveer.rentalmanagement.repository.RoleRepository;
import com.vinhveer.rentalmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    private boolean roleExists(RoleRequest roleRequest) {
        return roleRepository.existsByRoleName(roleRequest.getRoleName());
    }

    @Override
    public ResponseEntity<Object> GetAll() {
        try {
            List<Role> role = roleRepository.findAll();
            ListDataResponse<Object> listDataResponse = ListDataResponse.builder().message("OK").data(role).build();
            return ResponseEntity.ok(listDataResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occurred from server with exception = " + e);
        }
    }

    @Override
    public ResponseEntity<Object> Add(RoleRequest roleRequest) {
        try {
            if (roleExists(roleRequest)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists!");
            }
            Role role = new Role();
            role.setRoleName(roleRequest.getRoleName());

            roleRepository.save(role);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred from server with exception: " + e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Object> GetByID(long id) {
        try {
            Optional<Role> roleOptional = roleRepository.findById(id);
            if (roleOptional.isPresent()) {
                Role existingRole = roleOptional.get();
                return ResponseEntity.ok(existingRole);
            } else {
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder().message("Role not found!").build();
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
            if (roleRepository.existsById(id)) {
                roleRepository.deleteById(id);
                ListDataResponse<Object> listDataResponse = ListDataResponse.builder()
                        .message("Role " + id + " deleted " + "successfully").build();
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
    public ResponseEntity<Object> EditByID(RoleRequest roleRequest, long id) {
        try {
            Optional<Role> roleOptional = roleRepository.findById(id);
            if (roleOptional.isPresent()) {
                Role existingRole = roleOptional.get();

                if (!roleRequest.getRoleName().isBlank()) {
                    existingRole.setRoleName(roleRequest.getRoleName());
                }

                roleRepository.save(existingRole);

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
