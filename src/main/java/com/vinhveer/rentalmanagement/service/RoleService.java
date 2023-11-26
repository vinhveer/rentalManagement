package com.vinhveer.rentalmanagement.service;

import com.vinhveer.rentalmanagement.payload.request.RoleRequest;
import com.vinhveer.rentalmanagement.payload.request.UserRequest;
import org.springframework.http.ResponseEntity;

public interface RoleService {
    ResponseEntity<Object> GetAll();

    ResponseEntity<Object> Add(RoleRequest roleRequest);

    ResponseEntity<Object> GetByID(long id);

    ResponseEntity<Object> DeleteByID(long id);

    ResponseEntity<Object> EditByID(RoleRequest roleRequest, long id);
}
